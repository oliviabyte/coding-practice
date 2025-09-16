import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while(!stack.isEmpty() && nums[idx] >= stack.peek()) stack.pop();
            res[idx] = stack.isEmpty()? -1:stack.peek();
            stack.push(nums[idx]);
        }
        return res;
    }
}
