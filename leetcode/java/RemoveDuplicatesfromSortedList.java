package leetcode.java;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (null != quick) {
            if (quick.val != slow.val) {
                slow.next = quick;
                slow = slow.next;
            }
            quick = quick.next;
        }
        slow.next = null;
        return head;
    }
}
