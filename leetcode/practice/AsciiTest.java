package leetcode.practice;

public class AsciiTest {
    public static void main(String[] args) {
        String s1 = "paper";
        String s2 = "title";
        for (char c : s1.toCharArray()) {
            System.out.print((int) c + ",");
        }
        System.out.println();
        for (char c : s2.toCharArray()) {
            System.out.print((int) c + ",");
        }
    }
}
