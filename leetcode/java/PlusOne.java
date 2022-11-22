package leetcode.java;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] res = digits;
        int next = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (next == 0) {
                break;
            }
            int curr = digits[i] + next;
            if (curr >= 10) {
                next = 1;
                curr -= 10;
            } else {
                next = 0;
            }
            digits[i] = curr;
        }
        if (next == 1) {
            res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
        }
        return res;
    }
}
