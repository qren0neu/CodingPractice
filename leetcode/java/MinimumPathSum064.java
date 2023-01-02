package leetcode.java;

public class MinimumPathSum064 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j != 0) {
                        // first line
                        dp[i][j] = grid[i][j] + dp[i][j - 1];
                        continue;
                    }
                    if (i != 0 && j == 0) {
                        // first column
                        dp[i][j] = grid[i][j] + dp[i - 1][j];
                        continue;
                    }
                    if (i != 0 && j != 0) {
                        // others than the 0,0
                        // get the minimum of top or left
                        dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[grid.length - 1][grid[0].length - 1];
        }
    }
}
