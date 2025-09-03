package leetcode;


class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        ListNode(int val) { this.val = val; }
        ListNode() {}
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        for(int i = 0; i < count-n; i++) {
            prev = prev.next;
            curr = curr.next;
        }
        if(curr != null) {
            ListNode next = curr.next;
            prev.next = next;
        } else {
            prev.next = null;
        }
        return dummy.next;
    }
}
