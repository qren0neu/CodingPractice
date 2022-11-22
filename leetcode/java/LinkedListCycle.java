package leetcode.java;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        while (head != null) {
            if (head.val == Integer.MAX_VALUE) {
                return true;
            }
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }
}
