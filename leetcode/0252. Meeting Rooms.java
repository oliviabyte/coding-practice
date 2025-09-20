import java.util.*;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return true;
        // sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // if any intervals[i][1] > intervals[i+1][0] return false 
        for(int i = 1; i < n; i++) {
            if(intervals[i-1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;

        }
}
// Time complexity: O(nlogn)
// Space complexity: O(logn) or O(n)