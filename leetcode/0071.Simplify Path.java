package leetcode;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        for(int i = 0; i < pathArray.length; i++) {
            // case 1: 需要返回上一级
            if(pathArray[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // case 2: split后为空或者是.
            else if(pathArray[i].equals("") || pathArray[i].equals(".")) {
                continue;
            // case 3: 有效字符
            } else {
                stack.push(pathArray[i]);
            }
        }
        // edge case
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}