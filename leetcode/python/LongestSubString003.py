class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # two pointers
        slow = -1 # if we do not start from -1 here, will get wrong result with input of length 1
        quick = 0
        max_len = 0
        # record the position
        char_pos = {}
        for quick in range(0, len(s)):
            c = s[quick]
            if c in char_pos:
                pos = char_pos[c]
                slow = max(slow, pos) # update to non-repeating
            # always get max length which contains no repeat
            max_len = max(max_len, quick - slow)
            char_pos[c] = quick
        return max_len