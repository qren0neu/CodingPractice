package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n + 1);
        for (int i = 1; i <= n; i++) {
            result.add(cast(i));
        }
        return result;
    }

    private String cast(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        }
        if (n % 3 == 0) {
            return "Fizz";
        }
        if (n % 5 == 0) {
            return "Buzz";
        }
        return n + "";
    }
}
