package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // edge case
        if(intervals.length == 0) return 0;

        // sort the given intervals with its start time
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

        // create a minHeap to store the ending time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // add the first ending time to help init the traversal
        minHeap.add(intervals[0][1]);
        int res = 1;
        // traverse the given intervals, compare the starting time and the earlist ending time
        for(int j = 1; j < intervals.length; j++) {
            if(intervals[j][0] >= minHeap.peek()) {
                minHeap.poll();
            } else {
                res++;
            }
            minHeap.add(intervals[j][1]);
        }
        return res;
    }
}