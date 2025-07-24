package leetcode;
import java.util.Stack;


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node prev = null;
        Node head = null;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != null) {
                prev.right = curr;
                curr.left = prev;
            } else {
                head = curr;
            }
            prev = curr;

            curr = curr.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}
