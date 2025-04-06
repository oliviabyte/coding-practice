package leetcode;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // step1 spilt the given path into parts
        String[] parts = path.split("/"); // O(n)
        // step2 traverse each part
        for(String s : parts) { // O(n)
            if(s.equals(".") || s.equals("")) continue;
            else if(s.equals("..")) {
                if(stack.isEmpty()) continue;
                else {
                    stack.pop();
                }
            }
            else stack.push(s);
        }
        // step3 build the final result
        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
// Overall time complexity: O(n)
// space complexity: O(n)
