public class LowestCommonAncester {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int[] find = new int[] { 0, 0 };
            return helper(root, p, q, find);
        }

        private TreeNode helper(TreeNode root, TreeNode p, TreeNode q, int[] find) {
            if (root == null) {
                return null;
            }
            TreeNode n1 = helper(root.left, p, q, find);
            if (null != n1 && find[0] == 1 && find[1] == 1) {
                return n1;
            }
            TreeNode n2 = helper(root.right, p, q, find);
            if (null != n2 && find[0] == 1 && find[1] == 1) {
                return n2;
            }
            if (root.val == p.val)
                find[0] = 1;
            if (root.val == q.val)
                find[1] = 1;
            if (find[0] == 1 && find[1] == 1) {
                return root;
            }
            return null;
        }
    }

    static class Solution2 {

        private static final int[] ALL = { 1, 1 };
        private static final int[] NONE = { 0, 0 };

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode[] res = { null };
            helper(root, p, q, res);
            return res[0];
        }

        private int[] helper(TreeNode root, TreeNode p, TreeNode q, TreeNode[] find) {
            if (root == null) {
                return NONE;
            }
            int[] leftFind = helper(root.left, p, q, find);
            int[] rightFind = helper(root.right, p, q, find);
            // 1. check if sub tree find all
            if (null != find[0]) {
                // if we already get the result, it doesn't what we return
                return ALL;
            }
            // check if both sub tree find half
            if ((leftFind[0] == 1 && rightFind[1] == 1)
                    || (leftFind[1] == 1 && rightFind[0] == 1)) {
                // both find half, then root is the result
                // we do not consider left/right tree find both here
                // because, if 1. in sub tree there is left p right q, then sub tree is returned
                // if 2. in subtree there is left p left q, then left p is returned
                find[0] = root;
                return ALL;
            }
            // if result not find
            if (root == p) {
                // p is root
                // then find q
                if (leftFind[1] == 1 || rightFind[1] == 1) {
                    find[0] = root;
                    return ALL;
                } else {
                    // first time find p
                    return new int[] { 1, 0 };
                }
            } else if (root == q) {
                // q is root, then find p
                if (leftFind[0] == 1 || rightFind[0] == 1) {
                    find[0] = root;
                    return ALL;
                } else {
                    // first time find q
                    return new int[] { 0, 1 };
                }
            } else {
                // none find in root
                // maybe one is find in sub tree, maybe not
                // then we return the find one
                if (leftFind[0] == 1 || leftFind[1] == 1) {
                    return leftFind;
                } else {
                    return rightFind;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);
        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;
        t1.left = t0;
        t1.right = t8;
        System.out.println(new Solution2().lowestCommonAncestor(t3, t7, t0).val);
    }
}
