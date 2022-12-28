package leetcode.practice;

public class PalindromeTest {
    int maxStart = 1001;
    int maxEnd = 0;

    public String longestPalindrome(String s) {
        char[] chr = s.toCharArray();
        logestPalindrome(chr, 0, s.length() - 1);
        if (maxEnd - maxStart <= 0) {
            return s.substring(0, 1);
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public void logestPalindrome(char[] chr, int start, int end) {
        if (end - start < maxEnd - maxStart) {
            return;
        }
        if (start >= end) {
            return;
        }
        if (isPan(chr, start, end)) {
            maxEnd = end;
            maxStart = start;
        }

        logestPalindrome(chr, start + 1, end);
        logestPalindrome(chr, start, end - 1);
    }

    private boolean isPan(char[] chr, int start, int end) {
        int len = (end - start) % 2 == 0 ? (end - start) / 2 : (end - start + 1) / 2;
        for (int i = 0; i < len; i++) {
            char cs = chr[start + i];
            char ce = chr[end - i];
            if (cs != ce) {
                return false;
            }
        }
        return true;
    }
}
