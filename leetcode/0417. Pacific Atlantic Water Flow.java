package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, pac, heights[i][0]);
            dfs(heights, i, heights[0].length-1, atl, heights[i][heights[0].length-1]);
        }
        for(int i = 0; i < heights[0].length; i++) {
            dfs(heights, 0, i, pac, heights[0][i]);
            dfs(heights, heights.length-1, i, atl, heights[heights.length-1][i]);
        }

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;

    }
    void dfs(int[][] heights, int row, int column, boolean[][]curr, int prevHeight) {
        if(row < 0 || row >= heights.length || column < 0 || column >= heights[0].length || curr[row][column] || heights[row][column] < prevHeight) return;
        curr[row][column] = true;
        dfs(heights, row-1, column, curr, heights[row][column]);
        dfs(heights, row, column+1, curr, heights[row][column]);
        dfs(heights, row+1, column, curr, heights[row][column]);
        dfs(heights, row, column-1, curr, heights[row][column]);
    }
}