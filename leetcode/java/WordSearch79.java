package leetcode.java;

/**
 * https://leetcode.com/problems/word-search/description/
 * 
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid. The word can be constructed from letters of
 * sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch79 {
    class Solution {
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
}
