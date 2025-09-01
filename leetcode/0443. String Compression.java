package leetcode;

class Solution {
    private int compress(char[] chars) {
      if(chars.length == 0) return 0;
      int left = 0, right = 0;
      int i = 0;
      while(right <= chars.length) {
        if(right == chars.length || chars[left] != chars[right]) {
          chars[i++] = chars[left];
          int len = right - left;
          if(len > 1) {
            for(char c : String.valueOf(len).toCharArray()) {
              chars[i++] = c;
            }
          }
          left = right;
        }
        right++;
      }
        return i;
      }
  
    public static void main(String[] args) {
      Solution solution = new Solution();
      
      char[] test1 = {'a', 'a', 'a', 'b', 'b', 'c'};
      System.out.println(solution.compress(test1)); // 5
  
      char[] test2 = {};
      System.out.println(solution.compress(test2)); // 0
  
      char[] test3 = {'a'};
      System.out.println(solution.compress(test3)); // 1
  
      char[] test4 = {'a', 'b', 'c'};
      System.out.println(solution.compress(test4)); // 3
  
    }
  }
  
