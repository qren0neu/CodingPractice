package leetcode.java;

public class LongestPalindrome {
    int maxStart = 0;
    int maxEnd = 1;

    public String longestPalindrome(String s) {
        for (int x = 0; x < s.length(); x++) {
            findMax(s, x, x);
            findMax(s, x, x + 1);
        }
        return s.substring(maxStart, maxEnd);
    }

    private void findMax(String s, int left, int right) {
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxEnd - maxStart) {
            maxStart = left + 1;
            maxEnd = right;
        }
    }
}
