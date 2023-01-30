package datastructure.lecture5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator173 {
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
    class BSTIterator {

        private List<Integer> arr = new ArrayList<>();
        Iterator<Integer> iter;

        public BSTIterator(TreeNode root) {
            enqueue(root);
            iter = arr.iterator();
        }

        private void enqueue(TreeNode root) {
            if (root == null) {
                return;
            }
            enqueue(root.left);
            arr.add(root.val);
            enqueue(root.right);
        }

        public int next() {
            return iter.next();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
