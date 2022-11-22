class Solution(object):
    def firstUniqChar(self, str):
        """
        :type s: str
        :rtype: int
        """
        if len(str) == 1:
            return 0
        char_dict = []
        for i in range(0, 26): char_dict.append(-2)
        index = 0
        asca = ord('a')
        for s in str:
            asc = ord(s) - asca
            num = char_dict[asc]
            if num == -2:
                char_dict[asc] = index
            elif num >= 0:
                char_dict[asc] = -1
            index += 1
        mini = -1
        for i in char_dict:
            if i >= 0:
                if mini < 0:
                    mini = i
                mini = min(mini, i)
        return mini