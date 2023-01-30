package datastructure.lecture5;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedList109 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> arr = new ArrayList<>();
            while (null != head) {
                arr.add(head.val);
                head = head.next;
            }
            return bstHelper(arr, 0, arr.size() - 1);
        }

        private static TreeNode bstHelper(List<Integer> arr, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode();
            node.left = bstHelper(arr, left, mid - 1);
            node.right = bstHelper(arr, mid + 1, right);
            node.val = arr.get(mid);
            return node;
        }
    }

    class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            return bstHelper(head, null);
        }

        private static TreeNode bstHelper(ListNode head, ListNode tail) {
            if (head == tail) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow is in the middle
            TreeNode node = new TreeNode();
            node.left = bstHelper(head, slow);
            node.right = bstHelper(slow.next, tail);
            node.val = slow.val;
            return node;
        }
    }
}
