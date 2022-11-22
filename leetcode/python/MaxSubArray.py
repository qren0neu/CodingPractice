class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for index in range(1, len(nums)):
            # we always start at a value more than 0
            # because, if the previous value is making the result smaller, why would we do that? we should restart from a value bigger than 0
            # nums[index] is always the previous one + current one
            # as if it does not goes less than 0, we keep adding
            if nums[index-1] > 0:
                nums[index] = nums[index-1] + nums[index]
        
        return max(nums)