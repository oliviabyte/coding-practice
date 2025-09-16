import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for(int i : arr) {
            if (stack.isEmpty() || i >= stack.peek()) {
                stack.push(i);
            } else {
                max = stack.peek();
                while(!stack.isEmpty() && stack.peek() > i) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}
