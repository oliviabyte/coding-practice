package leetcode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        Stack<TreeNode> stack;
        TreeNode curr;
    class BSTIterator {
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            curr = root;
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
                }
        }
        public int next() {
            TreeNode node = stack.pop();
                if(node.right != null) {
                    TreeNode p = node.right;
                    while(p != null) {
                        stack.push(p);
                        p = p.left;
                    }
                }
                return node.val;
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */