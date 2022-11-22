def firstUniqChar(self, s):
        char_dict = {}
        for c in s:
            if c in char_dict:
                char_dict[c] += 1
            else:
                char_dict[c] = 1
        for i in range(len(s)):
            if char_dict[s[i]] == 1:
                return i
        return -1