package leetcode.java;

public class ValidPalindrome680 {
    class Solution {
        public boolean validPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i + 1, s.length());
                if (isPalindrome(left + right)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(right) != s.charAt(left)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    static class SolutionZY {
        public boolean validPalindrome(String s) {
            // cannot solve:
            // "aguokepatgbnvfqmgml[c]upuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc[u]lmgmqfvnbgtapekouga"
            int left = 0;
            int right = s.length() - 1;
            int skip = 0;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else if (s.charAt(left + 1) == s.charAt(right) && skip == 0) {
                    skip = 1;
                    left += 2;
                    right--;
                } else if (s.charAt(left) == s.charAt(right - 1) && skip == 0) {
                    skip = 1;
                    left++;
                    right -= 2;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution3 {
        public boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
                }
            }
            return true;
        }

        public boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(right) != s.charAt(left)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        boolean res = new ValidPalindrome680.Solution3().validPalindrome(s);
        System.out.println(res);
    }
}
