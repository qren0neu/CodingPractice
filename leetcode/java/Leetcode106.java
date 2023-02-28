package leetcode.java;

public class Leetcode106 {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTreeHelper(int[] inorder, int inorderstart, int inorderend, int[] postorder,
                int postorderstart, int postorderend) {
            if (inorderend - inorderstart < 0
                    || postorderend - postorderstart < 0) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postorderend]);
            // we get the root first
            for (int i = inorderstart; i <= inorderend; i++) {
                // go through in order to find the root
                if (inorder[i] == root.val) {
                    // we find the root in inorder
                    // then the left of root is its left tree, right right tree
                    // left part of post order: start from post start, end with post start + lenght
                    // of inorder left part
                    root.left = buildTreeHelper(inorder, inorderstart, i - 1, postorder, postorderstart,
                            postorderstart + (i - 1 - inorderstart));
                    // right part start from post left part + 1, end with left part + length of
                    // inorder right part
                    root.right = buildTreeHelper(inorder, i + 1, inorderend, postorder,
                            postorderstart + (i - 1 - inorderstart) + 1,
                            postorderstart + (i - 1 - inorderstart) + 1 + (inorderend - i - 1));
                    break;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 9, 3, 15, 20, 7 };
        int[] arr2 = { 9, 15, 7, 20, 3 };
    }
}
