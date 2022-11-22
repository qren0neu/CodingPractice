package leetcode.java;

public class LinkedListCycle3 {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (null != quick && null != quick.next) {
            if (quick == slow) {
                return true;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }
}
