public class GraphSearchTest {
    static class Solution1 {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            if (m == 0 || n == 0) {
                return false;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // go through each cell to find the match
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int k) {
            int m = board.length;
            int n = board[0].length;
            int h = word.length();
            // i < 0 or j < 0 or i >= m or j >= n, checking if the dfs is getting over the
            // boarder
            // k >= h, checking if the dfs is longer than the word we need
            // todo: one question:
            // typically if k == h - 1, does that mean we already find? will this situation
            // happen thant k >= h?
            if (i < 0 || j < 0 || i >= m || j >= n || k >= h) {
                return false;
            }
            // if the letter at board match the letter in the word
            if (board[i][j] == word.charAt(k)) {
                // if that is already the last one
                if (k == h - 1) {
                    return true;
                }
                // we are going to set mark the cell as visited in board
                // and we have to restore, so we store it first
                char temp = board[i][j];
                board[i][j] = '#'; // mark the cell as visited
                // right, left, upper, down
                boolean res = dfs(board, word, i + 1, j, k + 1) ||
                        dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1) ||
                        dfs(board, word, i, j - 1, k + 1);
                board[i][j] = temp; // unmark the cell
                return res;
            }
            return false;
        }
    }

    static class Solution2 {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            if (m == 0 || n == 0) {
                return false;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int k) {
            if (k == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length
                    || j < 0 || j >= board[0].length
                    || board[i][j] != word.charAt(k)) {
                return false;
            }
            char temp = board[i][j];
            board[i][j] = '#'; // mark visited
            boolean found = dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)
                    || dfs(board, word, i, j - 1, k + 1);
            board[i][j] = temp; // restore
            return found;
        }
    }

    static class Solution3 {
        public boolean exist(char[][] board, String word) {
            char begin = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == begin) {
                        if (dfs(board, i, j, word, 0)) {
                            // find one
                            return true;
                        }
                    }
                }
            }
            // all not found
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int len) {
            int wordlen = word.length();
            if (len == wordlen) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                // out of range
                return false;
            }
            if (board[i][j] != word.charAt(len)) {
                // not equal or visited
                return false;
            }
            // System.out.println(board[i][j]);
            char temp = board[i][j];
            board[i][j] = '#'; // set visited
            // return either of them find the word
            boolean res = dfs(board, i + 1, j, word, len + 1)
                    || dfs(board, i - 1, j, word, len + 1)
                    || dfs(board, i, j + 1, word, len + 1)
                    || dfs(board, i, j - 1, word, len + 1);
            board[i][j] = temp; // restore
            return res;
        }
    }

    static class Solution4 {
        public boolean exist(char[][] board, String word) {
            char begin = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == begin) {
                        if (dfs(board, i, j, word, 0)) {
                            // find one
                            return true;
                        }
                    }
                }
            }
            // all not found
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int len) {
            int wordlen = word.length();
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || len >= wordlen) {
                // out of range
                return false;
            }
            if (board[i][j] != word.charAt(len)) {
                // not equal or visited
                return false;
            }
            if (len >= wordlen - 1) {
                // find all characters in the word
                return true;
            }
            // System.out.println(board[i][j]);
            char temp = board[i][j];
            board[i][j] = '#'; // set visited
            // return either of them find the word
            boolean res = dfs(board, i + 1, j, word, len + 1) || dfs(board, i - 1, j, word, len + 1)
                    || dfs(board, i, j + 1, word, len + 1) || dfs(board, i, j - 1, word, len + 1);
            board[i][j] = temp; // restore
            return res;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' }
        };
        String word = "AAAAAAAAAAAAAAB";
        long start = System.currentTimeMillis();
        System.out.println(new Solution4().exist(board, word));
        System.out.println("Result generated in " + (System.currentTimeMillis() - start) + " milliseconds");
    }
}
