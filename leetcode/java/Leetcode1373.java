package leetcode.java;

/**
 * 1373. Maximum Sum BST in Binary Tree
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 */
public class Leetcode1373 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        int maxSum = 0;
        final int[] empty = new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        final int[] noneBST = new int[] { 0, 0, 0, 0 };

        public int maxSumBST(TreeNode root) {
            dfs(root);
            return maxSum;
        }

        private int[] dfs(TreeNode root) {
            if (null == root) {
                // empty node is a BST, but edge case
                return empty;
            }

            // post order, because we are going to go through the left and right sub trees
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int val = root.val;

            // left sub tree is BST
            // right sub tree is BST
            // val > left max and val < right min
            if (left[0] == 1 && right[0] == 1 && val > left[2] && val < right[1]) {
                // current tree is BST
                int[] res = new int[4];
                res[0] = 1;
                res[1] = Math.min(left[1], val); // deal with edge case (Math.MAX)
                res[2] = Math.max(right[2], val); // same as above
                res[3] = left[3] + right[3] + val;
                maxSum = Math.max(maxSum, res[3]);
                return res;
            } else {
                return noneBST;
            }
        }
    }
}
