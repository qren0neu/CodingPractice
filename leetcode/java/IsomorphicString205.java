package leetcode.java;

public class IsomorphicString205 {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] sarr = new int[128];
            int[] tarr = new int[128];
            for (int i = 0; i < s.length(); i++) {
                // assume that s.len = t.len
                char ct = t.charAt(i);
                char cs = s.charAt(i);
                // we store the mapping from s to t in sarr
                // and store the mapping from t to s in tarr
                int poss = (int) cs;
                int post = (int) ct;
                if (0 != sarr[poss] || 0 != tarr[post]) {
                    // if we find t in arr of s mapping
                    // double check if two s are pointing to same t
                    if (sarr[poss] != ct || tarr[post] != cs) {
                        return false;
                    }
                } else {
                    sarr[poss] = ct;
                    tarr[post] = cs;
                }
            }
            return true;
        }
    }
}
