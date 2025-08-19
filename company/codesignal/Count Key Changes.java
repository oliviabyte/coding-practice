package company.codesignal;


/*
 * Problem Statement
You are given an array of uppercase and lowercase English letters recording representing a sequence of letters typed by the user.
Your task is to count the number of times that the user changed keys while typing the sequence, considering that the uppercase and lowercase letters for a given letter require the user to press the same letter key (ignoring modifiers like Shift or Caps Lock). For example, typing 'W' and 'w' require the same key, while typing 'w' and 'e' require the user to change keys.

For example:
Typing 'w' and 'w' require the same key 'w'.
Typing 'A' and 'a' require the same key 'a'.
Typing 'b' and 'B' require the same key 'b'.
So the number of key changes is the number of times the user switches from one letter key to a different letter key.

Example
For recording = ['w', 'w', 'A', 'a', 'b', 'B'], the output should be solution(recording) = 2.

Explanation:
'w' and 'w' → same key
'A' and 'a' → same key
'b' and 'B' → same key
Sequence of key changes: w -> a -> b
Total number of key changes = 2

For recording = ['w', 'w', 'a', 'w', 'a'], the output should be solution(recording) = 3.
Explanation:
Key sequence: w -> a -> w -> a
Total number of key changes = 3
 */

class Solution {
    public int countKeyChanges(char[] recording) {
        int cnt = 0;
        for(int i = 1; i < recording.length; i++) {
            if(Character.toLowerCase(recording[i-1]) != Character.toLowerCase(recording[i])) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        // ['w', 'w', 'a', 'w', 'a'] - 3
        Solution sol = new Solution();
        System.out.println(sol.countKeyChanges(new char[]{'w', 'w', 'a', 'w', 'a'}) == 3? "pass" : "fail");
        System.out.println(sol.countKeyChanges(new char[]{'a'}) == 0? "pass" : "fail");
    }
}