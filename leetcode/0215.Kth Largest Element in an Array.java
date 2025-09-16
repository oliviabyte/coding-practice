import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int num : nums) {
            pq.add(num);
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if(count == k-1) return curr;
            count++; 
        }
        return -1; // should never reach here if input is valid
    }
}