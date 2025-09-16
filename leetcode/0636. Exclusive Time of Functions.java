import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        int lastestTime = 0;
        for(String log : logs) {
            String[] part = log.split(":");
            int currNum = Integer.parseInt(part[0]);

            if(part[1].equals("start")) {
                int currStart = Integer.parseInt(part[2]);
                if(stack.isEmpty()) {
                    stack.push(new int[] {currNum, currStart});
                    lastestTime = currStart;
                    continue;
                }
                result[stack.peek()[0]] += currStart - lastestTime;
                stack.push(new int[] {currNum, currStart});
                lastestTime = currStart;

            } else {
                int currEnd = Integer.parseInt(part[2]);
                result[currNum] += currEnd - lastestTime + 1;
                lastestTime = currEnd + 1;
                stack.pop();
            }
        }
        return result;
    }
}