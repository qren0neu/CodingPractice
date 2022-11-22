package leetcode.java;

public class ConvertBinaryInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            return head.val;
        }
        return getDecimalValueInternal(head)[1];
    }

    private int[] getDecimalValueInternal(ListNode head) {
        if (head.next == null) {
            int[] res = new int[] { 1, head.val };
            return res;
        }
        int[] fromNext = getDecimalValueInternal(head.next);
        int level = fromNext[0];
        int nextVal = fromNext[1];
        fromNext[0] = level + 1;
        fromNext[1] = nextVal + (int) (head.val * (Math.pow(2, level)));
        return fromNext;
    }
}
