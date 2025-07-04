package leetcode;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        DSU dsu = new DSU(n);
        for(int[] connection : connections) {
            dsu.union(connection[0], connection[1]);
        }
        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < n; i++) {
            roots.add(dsu.find(i));
        }
        return roots.size()-1;

    }
    private class DSU {
        int[] parent;
        public DSU(int N) {
            parent = new int[N];
            for(int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }
}