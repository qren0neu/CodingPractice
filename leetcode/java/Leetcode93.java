package leetcode.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class Leetcode93 {
    class Solution {

        private HashSet<String> set = new HashSet<String>();
        private List<String> res = new LinkedList<>();
    
        public List<String> restoreIpAddresses(String s) {
            for (int a = 1; a <= 3; a ++) {
                for (int b = 1; b <= 3; b ++) {
                    for (int c = 1; c <= 3; c++) {
                        for (int d = 1; d <= 3; d ++) {
                            if (a + b + c + d == s.length()) {
                                // begin
                                String A = s.substring(0, a);
                                if (A.length() > 1 && A.startsWith("0")) {
                                    continue;
                                }
                                String B = s.substring(a, a + b);
                                if (B.length() > 1 && B.startsWith("0")) {
                                    continue;
                                }
                                String C = s.substring(a + b, a + b + c);
                                if (C.length() > 1 && C.startsWith("0")) {
                                    continue;
                                }
                                String D = s.substring(a + b + c);
                                if (D.length() > 1 && D.startsWith("0")) {
                                    continue;
                                }
                                int AA = Integer.parseInt(A);
                                int BB = Integer.parseInt(B);
                                int CC = Integer.parseInt(C);
                                int DD = Integer.parseInt(D);
                                if (AA <= 255 && BB <= 255 && CC <= 255 && DD <= 255) {
                                    set.add(A + "." + B + "." + C + "." + D);
                                }
                            }
                        }
                    }
                }
            }
            for (String sinset : set) {
                res.add(sinset);
            }
            return res;
        }
    }

    class Solution2 {

        private HashSet<String> set = new HashSet<String>();
        private List<String> res = new LinkedList<>();
    
        public List<String> restoreIpAddresses(String s) {
            split("", 0, s, 3);
            split("", 0, s, 2);
            split("", 0, s, 1);
            for (String sinset : set) {
                res.add(sinset);
            }
            return res;
        }
    
        private void split(String addOn, int addOnLen, String s, int length) {
            if (length <= 0) {
                // in case
                return;
            }
            if (addOnLen == 4) {
                // satisfy the requirement
                if (s.length() > 0) {
                    return;
                }
                set.add(addOn);
                return;
            }
            if (s.length() < length) {
                // no more string to split
                return;
            }
            String sub = s.substring(0, length);
            int i = Integer.parseInt(sub);
            if (i > 255) {
                return;
            }
            if (sub.length() > 1 && sub.indexOf("0") == 0) {
                return;
            }
            String rem = s.substring(length, s.length());
            String next = addOn.isEmpty() ? sub : addOn + "." + sub;
            split(next, addOnLen + 1, rem, 3);
            split(next, addOnLen + 1, rem, 2);
            split(next, addOnLen + 1, rem, 1);
        }
    }
}
