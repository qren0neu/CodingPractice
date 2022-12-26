class Solution(object):
    # https://leetcode.com/problems/longest-increasing-subsequence/submissions/866005801/
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        index_lis = {} # index and its max lis
        for index in range(0, len(nums)):
            val_at_index = nums[index]
            max_lis = 0
            # max_idx = -1
            for idx in index_lis:
                lis = index_lis[idx]
                val_at_max = nums[idx]
                # if we get a higher value than the previous,
                # get the LIS at previous value and +1
                if val_at_max < val_at_index:
                    if lis > max_lis:
                        max_lis = lis
                        # max_idx = idx
                        # I wanted to update the index here to save time
                        # but I cannot, because it may updated by a wrong number
                        # Like: 1 2 9 3 4, we may want to get 1,2,3,4 but 9 may update the max so that we only get 1,2,9 
            # we do not store prev here, if we want, we may use a class or another dict
            # if max_idx >= 0:
            #     del index_lis[max_idx]
            index_lis[index] = max_lis + 1
        return max(index_lis.values())
            