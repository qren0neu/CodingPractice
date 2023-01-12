package leetcode.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class TopKFrequent347 {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // put frequency in the busket
            Map<Integer, Integer> busket = new HashMap<>();
            for (int i : nums) {
                if (busket.containsKey(i)) {
                    int count = busket.get(i);
                    busket.put(i, count + 1);
                } else {
                    busket.put(i, 1);
                }
            }
            Comparator<Entry<Integer, Integer>> myComparator = new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            };
            // put entry set in heap
            PriorityQueue<Entry<Integer, Integer>> heap = new PriorityQueue<>(busket.size(), myComparator);
            int[] res = new int[k];
            heap.addAll(busket.entrySet());
            for (int i = 0; i < k; i++) {
                res[i] = heap.poll().getKey();
            }
            return res;
        }
    }

    static class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            // put frequency in the busket
            Map<Integer, Integer> busket = new HashMap<>();
            for (int i : nums) {
                if (busket.containsKey(i)) {
                    int count = busket.get(i);
                    busket.put(i, count + 1);
                } else {
                    busket.put(i, 1);
                }
            }
            Comparator<Integer> myComparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // reverse order
                    return busket.get(o2) - busket.get(o1);
                }
            };
            // put entry set in heap
            PriorityQueue<Integer> heap = new PriorityQueue<>(busket.size(), myComparator);
            int[] res = new int[k];
            heap.addAll(busket.keySet());
            for (int i = 0; i < k; i++) {
                res[i] = heap.poll();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] res = new TopKFrequent347.Solution().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
