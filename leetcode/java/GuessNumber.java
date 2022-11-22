package leetcode.java;

public class GuessNumber {

    // private int n;
    private int right;

    public static void main(String[] args) {
        int n = 2126753390;
        int right = 1702766719;
        GuessNumber s = new GuessNumber();
        // s.n = n;
        s.right = right;
        // System.out.println(Integer.MAX_VALUE);
        System.out.println(s.guessNumber(n));
    }

    public int guess(int check) {
        if (check > right) {
            return -1;
        } else if (check < right) {
            return 1;
        } else {
            return 0;
        }
    }

    public int guessNumber(int n) {
        if (guess(n) == 0) {
            return n;
        }
        if (guess(1) == 0) {
            return 1;
        }
        int res = 0;
        int high = n;
        int low = 1;
        while (true) {
            if (high - low < 2) {
                return high;
            }
            res = low + (high - low) / 2;
            int guess = guess(res);

            System.out.println("high:" + high);
            System.out.println("low:" + low);
            System.out.println("res:" + res);

            // guess > 0, we picked a high value
            if (guess > 0) {
                low = res;
            } else if (guess < 0) {
                high = res;
            } else {
                break;
            }
        }
        return res;
    }
}
