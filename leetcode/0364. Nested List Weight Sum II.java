import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    class Pair {
        NestedInteger ni;
        int depth;

        Pair(NestedInteger ni, int depth) {
            this.ni = ni;
            this.depth = depth;
        }
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Stack<Pair> stack = new Stack<>();
        for(NestedInteger ni : nestedList) {
            stack.add(new Pair(ni, 1));
        }
        List<Integer> depthList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int depth = 1;
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            NestedInteger currNI = pair.getKey();
            int currentDepth = pair.getValue();

            if(currNI.isInteger()) {
                depthList.add(currentDepth);
                numList.add(currNI.getInteger());
                max = Math.max(currentDepth, max);
            } else {
                for(NestedInteger i : currNI.getList())
                stack.push(new Pair(i, currentDepth+1));
            }
        }
        int sum = 0;
        int weight = 0;
        for(int i = 0; i < depthList.size(); i++) {
            weight = max - depthList.get(i) + 1;
            sum += numList.get(i) * weight;
        }
        return sum;
    }
}