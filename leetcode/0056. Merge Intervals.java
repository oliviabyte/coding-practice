package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart > end) {
                list.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            } else {
                if(currEnd > end) end = currEnd;
            }
        }
        list.add(new int[]{start, end});
        
        return list.toArray(new int[list.size()][2]);
    }
}