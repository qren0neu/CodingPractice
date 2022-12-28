package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s.length() <= 2)
                return s.length();
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, right = 0, n = s.length();
            int res = 0, k = 2;
            // char pre = chars[left];
            while (right < n) {
                if (map.size() == k && !map.containsKey(chars[right])) {
                    int leftMost = n;
                    for (int index : map.values()) {
                        leftMost = Math.min(index, leftMost);
                    }
                    map.remove(chars[leftMost - 1]);
                    left = leftMost;
                }
                map.put(chars[right++], right);
                res = Math.max(right - left, res);
            }
            return res;
        }
    }

    class Solution003 {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }
}
