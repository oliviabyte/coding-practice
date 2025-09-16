import java.util.*;
// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// input: int[] nums, int k
// return type: int
// the count of subarray with k integers: atMost(K) - atMost(K-1)

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // init
        return atMost(nums, k) - atMost(nums, k-1);

        // traverse, if more than k, move left - to get the count of subarray at most k intergers
        // traverse again, if more than k-1...

        // kCount - k-1Count
    }
    private int atMost(int[] nums, int k) {
        int left = 0;
        int kCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(map.size() > k) {
                int leftNum = nums[left];
                int leftCount = map.get(leftNum) - 1;
                if(leftCount == 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], leftCount);
                }
                left++;
            }
            kCount += right - left + 1;
        }
        return kCount;
    }
}