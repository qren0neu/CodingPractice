package leetcode.java;

public class RemoveNthFromEnd19 {

    class Solution {

        int length = 0;

        public ListNode removeNthFromEnd(ListNode head, int n) {
            return traverse(head, n, 0);
        }

        public ListNode traverse(ListNode head, int n, int len) {
            if (head == null) {
                length = len;
                return head;
            }
            head.next = traverse(head.next, n, len + 1);
            if (len == (length - n)) {
                return head.next;
            }
            return head;
        }

        int count = 0;

        public ListNode removeNthFromEnd2(ListNode head, int n) {
            if (head == null) {
                return head;
            }
            head.next = removeNthFromEnd2(head.next, n);
            count++;
            if (count == n) {
                return head.next;
            }
            return head;
        }

        public ListNode removeNthFromEnd3(ListNode head, int n) {
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < n; i++) {
                // fast quicker n step than slow
                // so when we get to end, slow is at end - n
                fast = fast.next;
            }
            if (null == fast) {
                // in this situation means we have to delete the first
                return head.next;
            }
            while (null != fast && null != fast.next) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}