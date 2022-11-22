class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        flag = 1
        if x < 0:
            flag = -1
        x = x * flag
        lent = len(str(x))
        while x > 0:
            pos = x % 10
            mul = pow(10, (lent - 1))
            res += pos * mul
            x = int(x / 10)
            lent = lent - 1
        res = res * flag
        if res > pow(2, 31) - 1 or res < -pow(2, 31):
            return 0
        return res