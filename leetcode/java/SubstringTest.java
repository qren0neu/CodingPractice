package leetcode.java;

public class SubstringTest {
    public static void main(String[] args) {
        String s = "   abc  ";
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        s = s.substring(left, right + 1);
        System.out.println(s);
    }
}
