import java.util.*;
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        for(int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
        }
        for(Character ch : freqMap.keySet()) {
            maxHeap.add(ch);
        }
        while(!maxHeap.isEmpty()) {
            char currChar = maxHeap.poll();
            int freq = freqMap.get(currChar);
            while(freq > 0) {
                sb.append(currChar);
                freq--;
            }
        }
        return sb.toString();
    }
}