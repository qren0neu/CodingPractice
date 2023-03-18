package leetcode.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode863 {
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

        // store the distance from root
    private Map<Integer, List<Integer>> disMapLeft = new HashMap<Integer, Integer>;
    private Map<Integer, List<Integer>> disMapRight = new HashMap<Integer, Integer>;
        private int targetDistance;
        private boolean targetIsLeft;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList();
        if (k == 0) {
            res.add(root.val);
            return res;
        }
        helper(root, target, k, dis, true);
        helper(root, target, k, dis, false);
        if (targetIsLeft) {
            if (k > targetDistance) {
                // go over the root
                int dis1 = targetDistance - k;

            } else {
                // not go over the root
            
            }
            int dis2 = targetDistance 
        } else {
            if (k > targetDistance) {
                // go over the root

            } else {
                // not go over the root
            
            }
        }
    }

        public void helper(TreeNode root, TreeNode target, int k, int dis, boolean isleft) {
            if (root == null) {
                return;
            }
            if (root.val = target.val) {
                targetDistance = dis;
                targetIsLeft = isleft;
            }
            List<Integer> valuesOfDis = isleft ? disMapLeft.get(dis) : disMapRight.get(root.val);
            if (null == valuesOfDis) {
                valuesOfDis = new LinkedList<>();
            }
            valuesOfDis.add(root.val);
            if (isleft) {
                disMapLeft.put(dis, valuesOfDis);
            } else {
                disMapRight.put(dis, valuesOfDis);
            }
            helper(root.left, target, k, dis + 1, isleft);
            helper(root.right, target, k, dis + 1, isleft);
            return;
        }
    }

}
