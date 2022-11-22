class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # That's just the reverse version of https://leetcode.com/problems/maximum-subarray/
        cur = prices[0]
        res = 0
        for i in range(1, len(prices)):
            # we find price getting higher, we try to sell it
            # as higher price cannot be good for buy than lower price, we do not buy it at this time
            if prices[i] > cur:
                # we only try to get the best result
                res = max(res, prices[i] - cur)
            # otherwise, we try to buy it, because we get a lower price than the previous lowest
            else:
                cur = prices[i]
        return res