//             2.build the whole number
//             3.word pointer goes out of bounds
//             4.if our abbr finishes early, but word still has leftovers
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0; // move j through the word (word), move i through the abbreviation (abbr)
        for(int i = 0; i < abbr.length(); i++) {
            if(Character.isDigit(abbr.charAt(i))) {
                if (abbr.charAt(i) == '0') return false; // edge case1
                int num = 0; // to build a whole number
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    num = num * 10 + (abbr.charAt(i)-'0');
                    i++;
                }
                j += num;
                i--; // because next loop will i++
            } else {
                if(j >= word.length() || abbr.charAt(i) != word.charAt(j)) return false;
                j++;
            }
        }
        return j == word.length(); // If our abbr finishes early, but word still has leftovers
    }
}