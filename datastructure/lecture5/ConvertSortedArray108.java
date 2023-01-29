package datastructure.lecture5;

public class ConvertSortedArray108 {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayHelper(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayHelper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode();
            node.left = sortedArrayHelper(nums, left, mid - 1);
            node.right = sortedArrayHelper(nums, mid + 1, right);
            node.val = nums[mid];
            return node;
        }
    }
}
