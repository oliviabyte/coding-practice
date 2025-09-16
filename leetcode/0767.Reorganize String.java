import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        // 统计字符频率
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        // 创建最大堆，按频率排序
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> counts.get(b) - counts.get(a)
        );
        
        // 将所有字符加入堆中
        maxHeap.addAll(counts.keySet());
        
        // 检查是否可能重组
        char mostFrequent = maxHeap.peek();
        if (counts.get(mostFrequent) > (s.length() + 1) / 2) {
            return ""; // 如果最高频率超过一半，无法重组
        }
        
        StringBuilder result = new StringBuilder();
        
        // 每次取出两个不同的最高频率字符
        while (maxHeap.size() >= 2) {
            char char1 = maxHeap.poll();
            char char2 = maxHeap.poll();
            
            // 添加这两个字符到结果
            result.append(char1);
            result.append(char2);
            
            // 更新频率
            counts.put(char1, counts.get(char1) - 1);
            counts.put(char2, counts.get(char2) - 1);
            
            // 如果字符还有剩余，放回堆中
            if (counts.get(char1) > 0) {
                maxHeap.add(char1);
            }
            if (counts.get(char2) > 0) {
                maxHeap.add(char2);
            }
        }
        
        // 处理最后一个字符（如果有）
        if (!maxHeap.isEmpty()) {
            char lastChar = maxHeap.poll();
            result.append(lastChar);
        }
        
        return result.toString();
    }
}
