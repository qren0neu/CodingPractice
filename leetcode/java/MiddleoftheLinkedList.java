package leetcode.java;

public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode copy = head;
        while (null != copy.next && null != copy.next.next) {
            copy = copy.next.next;
            head = head.next;
        }
        return null != copy.next ? head.next : head;
    }
}
