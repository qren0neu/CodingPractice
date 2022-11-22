class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ''
        flag = False
        for i in range(0, 200):
            common = ''
            for str in strs:
                if str == '':
                    return ''
                if i < len(str):
                    current = str[i]
                    if common == '':
                        common = current
                    elif common != current:
                        common = ''
                        break
                else:
                    flag = True
                    break
            if flag or common == '':
                break
            res += common
        return res