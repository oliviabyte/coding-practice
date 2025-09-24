import java.util.*;
import java.util.LinkedList;
import java.util.Queue;




 // Definition for a binary tree node.


class Codec {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // edge case
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if(currNode == null) {
                sb.append("null,");
                continue;
            } else {
                sb.append(String.valueOf(currNode.val)).append(",");
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("null") || data.isEmpty()) {
            return null;
        }
        String[] treeStr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int n = treeStr.length;
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(treeStr[0]));
        queue.add(root);
        while(!queue.isEmpty() && i < n) {
            
            TreeNode parent = queue.poll();          
            if(i < n && !treeStr[i].equals("null")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(treeStr[i]));
                parent.left = leftChild;
                queue.add(leftChild);
            }
            i++;
            if(i < n && !treeStr[i].equals("null")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(treeStr[i]));
                parent.right = rightChild;
                queue.add(rightChild);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;