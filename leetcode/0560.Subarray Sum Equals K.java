import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] s = new int[nums.length+1];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            s[i+1] = s[i] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int sj : s) {
            if(map.containsKey(sj - k)) {
                count += map.get(sj - k);
            }
            map.put(sj, map.getOrDefault(sj, 0)+1);
        }
        return count;
    }
}