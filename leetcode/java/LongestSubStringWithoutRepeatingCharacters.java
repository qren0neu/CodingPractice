package leetcode.java;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] charr = s.toCharArray();
        int[] container = new int[256];
        int len = 1;
        for (int i = 0; i < charr.length; i++) {
            container[charr[i]] = 1;
            int j = i + 1;
            for (; j < charr.length; j++) {
                if (container[charr[j]] != 0) {
                    break;
                }
                container[charr[j]] = 1;
            }
            len = Math.max(len, j - i);
            container = new int[256];
        }
        return len;
    }
}