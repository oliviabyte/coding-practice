package leetcode;

import java.util.List;
import java.util.Stack;

// // This is the interface that allows for creating nested lists.
// // You should not implement it, or speculate about its implementation
// interface NestedInteger {
//     // Constructor initializes an empty nested list.
//     public NestedInteger();
//     // Constructor initializes a single integer.
//     public NestedInteger(int value);
//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();
//     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     // The result is undefined if this NestedInteger holds a nested list
//     public Integer getInteger();
//     // Set this NestedInteger to hold a single integer.
//     public void setInteger(int value);
//     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//     public void add(NestedInteger ni);
//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     // The result is undefined if this NestedInteger holds a single integer
//     public List<NestedInteger> getList();
// }

class Solution {
    class Pair {
        NestedInteger ni;
        int depth;

        Pair(NestedInteger ni, int depth) {
            this.ni = ni;
            this.depth = depth;
        }
    }
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<Pair> stack = new Stack<>();
        int sum = 0;
        for(NestedInteger ni : nestedList) {
            stack.push(new Pair(ni, 1));
        }
        while(!stack.isEmpty()) {
            Pair current = stack.pop();
            NestedInteger ni = current.getKey();
            int depth = current.getValue();

            if(ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                for(NestedInteger child : ni.getList()) {
                    stack.push(new Pair(child, depth+1));
                }
            }
        }
        return sum;
    }
    
}
