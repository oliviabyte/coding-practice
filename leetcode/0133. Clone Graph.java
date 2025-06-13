package leetcode;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;



class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node);
    }
    Node dfs(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node clone1 = new Node(node.val, new ArrayList());
        map.put(node, clone1);
        for(Node neighbor : node.neighbors) {
            Node clonedNeighbor = dfs(neighbor);
            clone1.neighbors.add(clonedNeighbor);
        }
        return clone1;
    }
}