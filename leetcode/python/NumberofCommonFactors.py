class Solution(object):
    def commonFactors(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        if a == 1 or b == 1:
            return 1
        list_a = []
        for i in range(2, a + 1):
            if a % i == 0:
                list_a.append(i)
        list_b = []
        for i in range(2, b + 1):
            if b % i == 0:
                list_b.append(i)
        return len([x for x in list_a if x in list_b]) + 1