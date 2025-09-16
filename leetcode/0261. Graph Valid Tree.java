import java.util.*;


class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 判断有没有环（如果是树edges数量必须是节点数量-1）
        if (edges.length != n - 1) return false;

        List<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build the graph
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0, graph, visited);

        // 判断连通性（是不是一整块连通分量）
        for(boolean visit : visited) {
            if(!visit) return false;
        }
        return true;
        
    }
    private void dfs(int curr, List<Integer>[] graph, boolean[] visited) {
        visited[curr] = true;
        for(int neighbor : graph[curr]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}