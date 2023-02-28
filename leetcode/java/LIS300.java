package leetcode.java;

public class LIS300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                // by default, at least each point should have a length of 1
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // we go through the array, if larger, we find it in dp
                    // and then add 1 to the value in dp
                    if (nums[i] > nums[j]) {
                        // always find the longest sub array
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        // the longest of all longest sub arrray
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            return max;
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                
            }
            return max;
        }

        public int binarySearch(int[] dp, int target) {
            int left = 0;
            int right = dp.length - 1;
            int mid = left + (right - left) / 2;
            while (left < right) {
                int midVal = dp[mid];
                
            }
        }
    }
}
