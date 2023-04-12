package leetcode.java;

public class Leetcode547 {
    class Solution1 {
        public int findCircleNum(int[][] isConnected) {
            int count = 0;
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1) {
                        dfs(isConnected, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] isConnected, int i, int j) {
            // int row = isConnected[i];
            isConnected[i][j] = 0;
            for (int n = 0; n < isConnected[i].length; n++) {
                if (isConnected[i][n] == 1) {
                    dfs(isConnected, i, n);
                }
            }
            for (int m = 0; m < isConnected.length; m++) {
                if (isConnected[m][j] == 1) {
                    dfs(isConnected, m, j);
                }
            }
        }
    }
}
