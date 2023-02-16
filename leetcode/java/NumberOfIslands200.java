package leetcode.java;

public class NumberOfIslands200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if (i >= m || j >= n || i < 0 || j < 0) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
