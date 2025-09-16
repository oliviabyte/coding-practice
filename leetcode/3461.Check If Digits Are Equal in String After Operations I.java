import java.util.*;

class Solution {
    public boolean hasSameDigits(String s) {
        // Edge case: If string has <2 characters
        if (s.length() < 2) return false;
        // Convert a string to a list of numbers
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c - '0');
        }
        // Repeat until only two numbers remain
        while(list.size() > 2) {
            List<Integer> newList = new ArrayList<>();
            for(int j = 0; j+1 < list.size(); j++) {
                int modulo = (list.get(j) + list.get(j + 1)) % 10;
                newList.add(modulo);
            }
            list = newList;
        }
        return list.get(0).equals(list.get(1));
    }
}