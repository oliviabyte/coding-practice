// capacity control -> 
import java.util.*;

class LRUCache {
    class ListNode {
        String key;
        Object val;
        ListNode prev;
        ListNode next;
        public ListNode(String key, Object val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<String, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(null, null);
        tail = new ListNode(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public Object get(String key) {
        if(!map.containsKey(key)) return null;
        ListNode curr = map.get(key);
        remove(curr);
        add(curr);
        return curr.val;
        
    }
    
    public void put(String key, Object value) {
        if(map.containsKey(key)) {
            ListNode existing = map.get(key);
            existing.val = value;
            remove(existing);
            add(existing);
            return;
        }
        if(map.size() >= capacity) {
            ListNode nodeToRemove = tail.prev;
            remove(nodeToRemove);
            map.remove(nodeToRemove.key);
        }
        ListNode curr = new ListNode(key, value);
        add(curr);
        map.put(key, curr);
    }

    public void add(ListNode node) {
        ListNode nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
