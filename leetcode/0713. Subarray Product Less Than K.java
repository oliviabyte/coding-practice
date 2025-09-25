import java.util.*;

// 易错：
// 任何一个非空子数组，它的乘积至少是 1。
// 如果 k = 1，那么就不可能存在任何一个子数组，其乘积能“严格小于1”。

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // edge case
        if(nums.length == 0 || k <= 1) return 0;

        int res = 0, left = 0, product = 1;
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while(product >= k) {
                product = product / nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
