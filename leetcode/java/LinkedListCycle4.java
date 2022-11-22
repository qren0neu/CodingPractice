package leetcode.java;

import java.util.HashMap;

public class LinkedListCycle4 {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            } else {
                map.put(head, head.val);
            }
            head = head.next;
        }
        return false;
    }
}
