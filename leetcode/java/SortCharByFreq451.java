package leetcode.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFreq451 {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (freqMap.containsKey(c)) {
                    int count = freqMap.get(c);
                    freqMap.put(c, count + 1);
                } else {
                    freqMap.put(c, 1);
                }
            }
            char[] res = new char[s.length()];
            Comparator<Character> myComparator = new Comparator<>() {
                public int compare(Character c1, Character c2) {
                    return freqMap.get(c2) - freqMap.get(c1);
                }
            };
            PriorityQueue<Character> pq = new PriorityQueue<>(freqMap.size(), myComparator);
            pq.addAll(freqMap.keySet());
            for (int i = 0; i < res.length; ) {
                char c = pq.poll();
                int count = freqMap.get(c);
                for (int j = 0; j < count; j++) {
                    res[i] = c;
                    i++;
                }
            }
            return new String(res);
        }
    }
}
