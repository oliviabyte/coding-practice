import java.util.*;
class TopKFrequent {
    private int[] solutionPrioirityQueue(int[] nums, int k) {
        int[] res = new int[k];
        // 1. build a freqMap and traverse to get the freq: O(N)
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (final int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        // 2. creat a minHeap and maintain the length of minHeap is topK: O(N log k)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        for (final int i : freqMap.keySet()) {
            pq.add(i); // pq的插入操作time complexity：O(log k)
            while(pq.size() > k) {
                pq.poll(); // pq的删除操作time complexity：O(log k)
            }
        }
        //注意⚠️ 题目没有要求输出顺序，但是因为用的是minHeap，poll（）会是从小到大输出的
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        // 如果要从出现次数多到小输出的话
        // for (int i = k-1; i >= 0; i--) {
        //     res[i] = pq.poll();
        // }
        return res;
    }
    private int[] solutionQuickselect(int[] nums, int k) {
        
    }
}
