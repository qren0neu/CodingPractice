# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def __init__(self):
        self.size = 0

    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        if head.next is None:
            return None
        self.sliceList(head, 0, n)
        if self.size == n:
            head = head.next
        return head

    def sliceList(self, head, pos, n):
        if head is None:
            self.size = pos
            return
        self.sliceList(head.next, pos + 1, n)
        if pos == self.size - n - 1:
            head.next = head.next.next