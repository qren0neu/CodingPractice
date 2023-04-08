package leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> result = new ArrayList<>();
            Map<TreeNode, TreeNode> parent = new HashMap<>();
            findParent(root, null, parent);
            findNodes(target, k, result, parent);
            return result;
        }

        private void findParent(TreeNode node, TreeNode parentNode, Map<TreeNode, TreeNode> parent) {
            if (node == null) {
                return;
            }
            parent.put(node, parentNode);
            findParent(node.left, node, parent);
            findParent(node.right, node, parent);
        }

        private void findNodes(TreeNode node, int k, List<Integer> result, Map<TreeNode, TreeNode> parent) {
            if (node == null) {
                return;
            }
            if (k == 0) {
                result.add(node.val);
                return;
            }
            Set<TreeNode> visited = new HashSet<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            visited.add(node);
            int dist = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    if (curr.left != null && visited.add(curr.left)) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null && visited.add(curr.right)) {
                        queue.offer(curr.right);
                    }
                    if (parent.get(curr) != null && visited.add(parent.get(curr))) {
                        queue.offer(parent.get(curr));
                    }
                }
                dist++;
                if (dist == k) {
                    for (TreeNode n : queue) {
                        result.add(n.val);
                    }
                    return;
                }
            }
        }
    }

}
