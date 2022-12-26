class Solution(object):
    def fib(self, n):
        """
        :type n: int
        :rtype: int
        """
        dic = {}
        return self.fibImpl(n, dic)

    def fibImpl(self, n, dic):
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n in dic:
            return dic[n]
        else:
            dic[n] = self.fibImpl(n - 1, dic) + self.fibImpl(n - 2, dic)
        return dic[n]