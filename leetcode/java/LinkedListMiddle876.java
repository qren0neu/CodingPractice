package leetcode.java;

public class LinkedListMiddle876 {
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
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode copy = head;
            while (null != copy.next && null != copy.next.next) {
                copy = copy.next.next;
                head = head.next;
            }
            return null != copy.next ? head.next : head;
        }
    }
}
