package leetcode.java;

public class ClimbingStairs070 {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            // when climbing stairs, we have only 2 steps and 1 step
            // so when we get to the top, we can only take 2 and 1
            // and next, and next...
            int[] dp = new int[n + 1];
            // we use this to store each step takes how many ways
            // initialize
            dp[1] = 1; // 1
            dp[2] = 2; // 1 + 1 or 2
            for (int i = 3; i < n + 1; i++) {
                // 1. take 2 stairs from last step
                // 2. take 1 stair from last step
                // ways: the sum
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
