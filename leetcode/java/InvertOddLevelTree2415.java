package leetcode.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertOddLevelTree2415 {
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
        public TreeNode reverseOddLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 1;
            while (queue.size() > 0) {
                if (level % 2 == 0) {
                    // even, from right to left, but add right child first
                    TreeNode head = queue.remove();
                    queue.add(head.right);
                    queue.add(head.left);
                } else {
                    // odd, reverse
                    TreeNode tail = queue.poll();
                    queue.add(tail.left);
                    queue.add(tail.right);
                }
            }
        }
    }
}
