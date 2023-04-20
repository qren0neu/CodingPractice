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

    class Solution2 {
        public int findCircleNum(int[][] isConnected) {
            UnionFind uf = new UnionFind(isConnected.length);
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.getCount();
        }

    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        UnionFind(int n) {
            count = n;
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int proot = find(p);
            int qroot = find(q);
            if (proot == qroot)
                return;
            if (rank[p] > rank[q]) {
                parent[qroot] = proot;
                rank[p]++;
            } else {
                parent[proot] = qroot;
                rank[q]++;
            }
            count--;
        }

        public int find(int p) {
            while (parent[p] != p) {
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int getCount() {
            return count;
        }
    }
}
