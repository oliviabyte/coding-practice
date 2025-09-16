import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < nums2.length; i++) {
            idx.put(nums2[i], i);
        }
        int[] res = new int[nums2.length];
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length -1; i >= 0; i--) {
            int x = nums2[i];
            while(!stack.isEmpty() && x >= stack.peek()) stack.pop();

            res[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(x);
        }
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = res[idx.get(nums1[i])];
        }
        return ans;
    }
}