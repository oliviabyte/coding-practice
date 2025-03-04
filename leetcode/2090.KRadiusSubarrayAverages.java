package leetcode;
import java.util.Arrays;

class Solution {
    /**
     * Calculate the k-radius average for each element in the array.
     * The k-radius average for an element is the average of the element and its k left and right neighbors.
     * If an element has less than k neighbors on either side, its k-radius average is -1.
     *
     * Input:
     * - nums: an array of integers
     * - k: the radius for calculating averages
     * 
     * Output:
     * - an array of integers where each element is the k-radius average or -1 if not enough neighbors
     */
    public int[] getAverages(int[] nums, int k) {
        // 1: Initialize the result array with -1
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        
        // 2: Initialize a running sum for the sliding window
        long sum = 0;
        
        // 3: Slide the window and calculate averages
        for(int i = 0; i < nums.length; i++) {
            // Add current element to the running sum
            sum += nums[i];
            
            // Skip if window size is not yet 2k+1
            if (i < k * 2) {
                continue;
            }
            
            // Calculate and store the average at the center position of the window
            res[i - k] = (int) (sum / (k * 2 + 1));
            
            // Remove the leftmost element from the window
            sum -= nums[i - k * 2];
        } 
        return res;
    }
}
// Time Complexity: O(n) where n is the length of nums
// Space Complexity: O(n) for the result array