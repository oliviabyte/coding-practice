package leetcode;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
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