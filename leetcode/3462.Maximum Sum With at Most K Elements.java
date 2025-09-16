import java.util.*;

class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            
            for(int j = grid[i].length - 1; j >= 0; j--) {
                if(limits[i] != 0) {
                pq.add(grid[i][j]);
                limits[i]--;
                }
            }
        }
        while(k > 0 && !pq.isEmpty()) {
            res += pq.poll();
            k--;
        }
        return res;
    }
}
