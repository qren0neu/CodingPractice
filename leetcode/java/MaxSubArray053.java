package leetcode.java;

public class MaxSubArray053 {
    class Solution {
        public int maxSubArray(int[] nums) {
            // if the new number is larger than the potential sum, we restart
            // and for the max, we always get the max.
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                // if current value is more than the possible sum previously
                // we restart
                if (val >= (sum + val)) {
                    sum = 0;
                }
                sum += val;
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            // DP:
            int[] dp = new int[nums.length];
            // I think we should get all the max value at each position
            // and return the max value in the dp Array
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // every position stores the possible max value at each position
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
            // find max in dp
            int max = -100001;
            for (int val : dp) {
                max = Math.max(max, val);
            }
            return max;
        }
    }
}
