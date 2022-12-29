package leetcode.java;

public class UniquePaths063 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int dp[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (i == 0 || j == 0) {
                        // in first row or column, all 1 way
                        dp[i][j] = 1;
                        if (i > 0) {
                            // j = 0, check if blocked
                            // if block, we have to change the initialization
                            dp[i][j] = dp[i - 1][j];
                        }
                        if (j > 0) {
                            // i = 0, also check block
                            dp[i][j] = dp[i][j - 1];
                        }
                        continue;
                    }
                    // 2 "ways": go down or go right to get to the final
                    // and each one the same when we see it as "final"
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
