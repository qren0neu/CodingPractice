package leetcode.java;

import java.util.List;

/**
 * https://leetcode.com/problems/strictly-palindromic-number/description/
 * 2396. Strictly Palindromic Number
 */
public class Leetcode2396 {
    class Solution {
        public boolean isStrictlyPalindromic(int n) {
            // go from 2 ~ n-2 and check if is palindromic
            for (int i = 2; i <= n - 2; i++) {
                // base as n
                List<Integer> arr = change2arr(n, i);
                if (!checkPalindromic(arr)) {
                    return false;
                }
            }
            return true;
        }

        private List<Integer> change2arr(int n, int base) {
            List<Integer> arr = new ArrayList<>();
            while (n != 0) {
                arr.add(n % base);
                n = n / base;
            }
            return arr;
        }

        private boolean checkPalindromic(List<Integer> arr) {
            int left = 0;
            int right = arr.size() - 1;
            while (left <= right) {
                int li = arr.get(left);
                int ri = arr.get(right);
                if (li != ri) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
