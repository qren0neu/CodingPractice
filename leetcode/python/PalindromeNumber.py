class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        str_x = str(x)
        full = len(str_x)
        half = int(full / 2)
        for i in range(half):
            if str_x[i] != str_x[full - i - 1]:
                return False
        return True