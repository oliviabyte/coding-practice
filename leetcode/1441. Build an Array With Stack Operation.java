import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int pointer = 0;
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(pointer == target.length) return res;
            res.add("Push");
            if(i != target[pointer]) res.add("Pop");
            else pointer++;
        }
        return res;

    }
}
