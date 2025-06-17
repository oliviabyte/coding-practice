package leetcode;
import java.util.Stack;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            } else {
                int maxInMergedChunk = stack.peek();
                while(!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(maxInMergedChunk);
            }
            if(!stack.isEmpty() && arr[i] < stack.peek()) {
                int maxInMergedChunk = stack.pop();
                stack.push(maxInMergedChunk);
            }
        }
        return stack.size();
    }
}
