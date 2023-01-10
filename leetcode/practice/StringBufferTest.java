package leetcode.practice;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer buffer1 = new StringBuffer();
        buffer1.append("Hello World!");
        System.out.println(buffer1.toString());
        buffer1.setLength(0);
        System.out.println(buffer1.toString());
    }
}
