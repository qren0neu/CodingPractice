package leetcode.java;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/description/
 * 
 * move quick
 * if match, move slow
 * check if slow reaches the end
 * 
 */
public class Leetcode392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int i = 0; // scan s
            int j = 0; // scan t
            for (j = 0; j < t.length(); j++) {
                if (i >= s.length())
                    return true;
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
            }
            return i == s.length();
        }
    }
}
