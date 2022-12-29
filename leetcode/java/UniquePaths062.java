package leetcode.java;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths062 {
    class Solution {
        public int uniquePaths(int m, int n) {
            // similar to the climing stairs?
            // 2 choices, 1 -> right, 2 -> bottom
            // we always start from 0, 0
            return uniquePathsImple(m - 1, n - 1);
        }

        /**
         * This will exceed time limit
         */
        public int uniquePathsImple(int m, int n) {
            if (m == 0) {
                // if we take n right to the most right, this count as 1 "way"
                return 1;
            }
            if (n == 0) {
                return 1;
            }
            return uniquePathsImple(m - 1, n)
                    + uniquePathsImple(m, n - 1);
        }
    }

    class Solution2 {
        public int uniquePaths(int m, int n) {
            // This way is wrong because of the initialization
            // And will work in a wrong but working way
            // But finally still cause an error
            int dp[][] = new int[m + 1][n + 1];
            // we cannot just init it in this way, we have to init a line
            dp[0][1] = 1;
            dp[1][0] = 1;
            dp[0][0] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(dp[i][j] + ", ");
                }
                System.out.println();
            }
            return dp[m][n] / 2; // This will exceed integer limit
        }
    }

    class Solution3 {
        public int uniquePaths(int m, int n) {
            int dp[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        // in first row or column, all 1 way
                        dp[i][j] = 1;
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
