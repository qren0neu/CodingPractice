package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class FiboNumber509 {
    class Solution {
        // space to time
        public int fib(int n) {
            List<Integer> arr = new ArrayList<>();
            arr.add(0);
            arr.add(1);

            for (int i = 2; i <= n; i++) {
                arr.add(arr.get(i - 1) + arr.get(i - 2));
            }

            return arr.get(n);
        }
    }

    class Solution2 {
        // recursion
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }
}
