package leetcode.java;

public class PalindromeLinkedList {
    private boolean result = true;
    private ListNode copy;

    public boolean isPalindrome(ListNode head) {
        copy = new ListNode(head.val, head.next);
        try {
            recurse(head);
        } catch (Exception e) {

        }
        return result;
    }

    private void recurse(ListNode head) {
        ListNode temp = head.next;
        if (null != temp) {
            // go to last
            recurse(temp);
        }
        if (result) {
            result = head.val == copy.val;
        } else {
            throw new RuntimeException();
        }
        copy = copy.next;
    }
}
