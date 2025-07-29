package leetcode;

class Solution {
    public int maxArea(int[] height) {
        int amount = 0;
        int max = 0;
        int left = 0, right = height.length-1;
        while(left < right) {
            if(height[left] <= height[right]) {
                amount = height[left] * (right - left);
                left++;
            }
            else if(height[left] > height[right]) {
                amount = height[right] * (right - left);
                right--;
            }
            max = Math.max(amount, max);
        }
        return max;
    }
}