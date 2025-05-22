package leetcode;

import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26]; // 是用来记录 “未来还会不会再遇到这个字符” 的，而不是用来统计栈中的内容
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c-'a']--;
            if(set.contains(c)) continue;
            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && freq[stack.peek() -'a'] > 0) {
                set.remove(stack.pop());
            }
            stack.push(c);
            set.add(c);
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}