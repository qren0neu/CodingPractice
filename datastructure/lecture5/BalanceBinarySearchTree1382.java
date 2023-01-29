package datastructure.lecture5;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 */
public class BalanceBinarySearchTree1382 {
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
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> valList = new ArrayList<>();
            dfs(valList, root);
            return createBST(valList, 0, valList.size() - 1);
        }

        public List<Integer> dfs(List<Integer> valList, TreeNode root) {
            if (root == null) {
                return valList;
            }
            dfs(valList, root.left);
            valList.add(root.val);
            dfs(valList, root.right);
            return valList;
        }

        public TreeNode createBST(List<Integer> valList, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2; // or start + (end - start) / 2
            TreeNode left = createBST(valList, start, mid - 1);
            TreeNode right = createBST(valList, mid + 1, end);
            TreeNode node = new TreeNode(valList.get(mid), left, right);
            return node;
        }
    }
}
