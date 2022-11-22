package leetcode.java;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0;
        ListNode head = new ListNode();
        ListNode pointer = head;
        while (true) {
            int v1 = 0;
            int v2 = 0;
            if (null != l1) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + next;
            if (sum >= 10) {
                sum = sum - 10;
                next = 1;
            } else {
                next = 0;
            }
            pointer.val = sum;
            if (null == l1 && null == l2 && next == 0) {
                break;
            }
            pointer.next = new ListNode(next);
            pointer = pointer.next;
        }
        return head;
    }
}
