package leetcode.java;

public class NumberofStepstoReduceaNumbertoZero2 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (by2(num)) {
                num = num / 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }

    private boolean by2(int num) {
        int res = num % 10;
        return res % 2 == 0;
    }
}
