class Solution:
    def myAtoi(self, s: str) -> int:
        sint = ''
        flag = 1
        lent = 0
        for ss in s:
            ords = ord(ss)
            if ords == 43 or ords == 45:
                if lent > 0:
                    break
                lent += 1
                if ords == 45:
                    flag = -1
                continue
            if ords == 32:
                if lent > 0:
                    break
                else:
                    continue
            if 48 <= ords <= 57:
                sint = sint + ss
                lent += 1
            else:
                break
        if sint == '':
            return 0
        res = int(sint) * flag
        maxi = 2**31 - 1
        mini = -(2**31)
        if res > maxi:
            return maxi
        if res < mini:
            return mini
        return res