import java.util.*;


// Definition for a binary tree node.
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
}

// A brute-force approach: generate all paths and check their sums, but that’s inefficient
// Instead, I’ll use DFS with backtracking to efficiently explore only valid paths
// Backtracking typically uses parameters to maintain the current state
// (such as the target sum and recursion depth)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    // global variable curr: a container for the current state
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum) {
        if(root == null) return;
        // add current val to curr
        curr.add(root.val);
        // check if we find a valid path (leaf node with sum matching target)
        if(root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(curr)); // can't let state be influenced
        }
        // 回溯只影响curr列表，不会改变targetSum值，下面的targetSum值是自己独立的
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        // Backtrack: remove the last added node to explore other paths
        curr.remove(curr.size() - 1);
        return;
    }
}
