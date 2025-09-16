import java.util.*;


// ops <= k -> prevOps + (nums[right] - nums[right-1]) * (right - left)  <= k
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, ops = 1, maxCount = 0;
        for(int right = 0; right < nums.length; right++) {
            if(right > 0) {
                ops += (nums[right] - nums[right-1]) * (right - left);
            }
            if(ops > k) {
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
        
    }
}