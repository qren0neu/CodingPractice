package leetcode.java;

public class PlusOne2 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // add 1
                digits[i]++;
                // no need to continue to add 1
                return digits;
            }
            // 9 -> 10 -> 0
            digits[i] = 0;
        }
        // to run in this case, we only have 10, 100, 1000, etc
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
