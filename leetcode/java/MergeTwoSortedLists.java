package leetcode.java;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // special cases
        ListNode head = new ListNode();
        ListNode pointer = head;
        while (true) {
            int v1 = 101;
            int v2 = 101;
            // we cannot use 0 here, because we are going to compare who are smaller, and
            // "null" cannot be taken as what we want
            if (null != list1) {
                v1 = list1.val;
            }
            if (null != list2) {
                v2 = list2.val;
            }
            if (v1 < v2) {
                pointer.val = v1;
                list1 = list1.next;
            } else {
                pointer.val = v2;
                list2 = list2.next;
            }
            if (null == list1 && null == list2) {
                break;
            }
            pointer.next = new ListNode();
            pointer = pointer.next;
        }
        return head;
    }
}
