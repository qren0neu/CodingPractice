package leetcode.java;

import java.util.Arrays;

public class Leetcode003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int length = 0;
            int fast = 0;
            int slow = 0;
            int[] count = new int[128];
            Arrays.fill(count, -1);
            for (fast = 0; fast < s.length(); fast++) {
                char cur = s.charAt(fast);
                if (count[cur] != -1) {
                    // repeat
                    length = Math.max(length, fast - slow);
                    // move slow
                    slow = Math.max(slow, count[cur] + 1);
                }
                count[cur] = fast;
            }
            length = Math.max(length, fast - slow);
            return length;
        }
    }
}
