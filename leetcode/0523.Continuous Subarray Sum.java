package leetcode;
import java.util.HashMap;

// s[i+1] = s[i]+nums[i]
// (s[i+1] - s[j]) % k = 0 -> s[i+1] % k = s[j] % k
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 1 create the prefix array
        int[] s = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            s[i+1] = s[i] + nums[i];
        }
        // 2 create the hashmap, check if there's a same remainder in the hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < s.length; j++) {
            int remainder = s[j] % k;
            if(map.containsKey(remainder)) {
                if(j - map.get(remainder) >= 2) return true;
            } else {
                // 3 put(remainder, j)
                map.put(remainder, j);
            }
                
        }
        return false;
    }
}
// time: O(N)
// space: O(N)