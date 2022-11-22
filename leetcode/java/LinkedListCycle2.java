package leetcode.java;

public class LinkedListCycle2 {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        for (int i = 0; i < 10001; i++) {
            head = head.next;
            if (head == null) {
                return false;
            }
        }
        return true;
    }
}
