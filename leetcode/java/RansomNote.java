package leetcode.java;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        char[] arrM = magazine.toCharArray();
        for (char c : arrM) {
            alphabet[c - 'a']++;
        }
        char[] arrN = ransomNote.toCharArray();
        for (char c : arrN) {
            if (--alphabet[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
