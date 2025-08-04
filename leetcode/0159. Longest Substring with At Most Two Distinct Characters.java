import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size() > 2) {
                char c = s.charAt(left);
                if(map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c)-1);
                left++;
            }
            max = Math.max(max, right - left + 1); 
        }
        return max;
    }
}