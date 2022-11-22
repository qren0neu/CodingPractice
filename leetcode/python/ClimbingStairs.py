class Solution(object):

    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        storage = {}
        return self.climbStairsImpl(n, storage)

    def climbStairsImpl(self, n, storage):
        if n == 2: return 2
        if n == 1: return 1
        if n in storage:
            return storage[n]
        n1 = self.climbStairsImpl(n - 1, storage)
        n2 = self.climbStairsImpl(n - 2, storage)
        storage[n - 1] = n1
        storage[n - 2] = n2
        return n1 + n2