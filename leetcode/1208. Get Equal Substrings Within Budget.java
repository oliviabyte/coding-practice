// cost < maxCost -> Sum(Math.abs(s.charAt(right) - t.charAt(right))) < maxCost

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // init
        int left = 0, cost = 0, max = 0;

        for(int right = 0; right < s.length(); right++) {
            cost += Math.abs(t.charAt(right) - s.charAt(right));

            // 换掉的数量 > maxCost的话
            while(cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
