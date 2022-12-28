package leetcode.java;

public class LongestPalindrome3 {
    private char[] arr;

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        arr = s.toCharArray();
        int maxStart = 0;
        int maxEnd = 1;
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int x = 0; x < len; x++) {
            for (int y = len - 1; y >= x + 1; y--) {
                if (isPan(x, y)) {
                    if (y - x >= maxEnd - maxStart) {
                        maxStart = x;
                        maxEnd = y + 1;
                        break;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd);
    }

    private boolean isPan(int start, int end) {
        while (start < end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
