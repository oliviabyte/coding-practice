package leetcode;

import java.util.Stack;

/*
we can using stack to solve this problem
as we traverse through the given array
    whenever we encounter a number: push it onto the stack
    when we encounter an operator, pop two numbers from the stack, apply the operation, push the result back onto the stack
*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if("+-*/".contains(token)) { // ⚠️ 代码规范：小且固定的集合，用 contains() 比多次 equals() 比较更好。
                int y = stack.pop();
                int x = stack.pop();
                switch(token) {
                    case "+":
                        stack.push(x+y);
                        break;
                    case "-":
                        stack.push(x-y);
                        break;
                    case "*":
                        stack.push(x*y);
                        break;
                    case "/":
                        stack.push(x/y);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}