class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0:
            return False
        stack = []
        forth_list = ['(', '[', '{']
        back_list = [')', ']', '}']
        pair = {'(': ')', '[': ']', '{': '}', ')': '(', ']': '[', '}': '{'}
        for c in s:
            if c in forth_list:
                stack.append(c)  # stack in
            if c in back_list:
                find_pair = False
                while len(stack) != 0:
                    curr = stack.pop()
                    curr_pair = pair[curr]
                    if curr_pair != c:
                        return False
                    else:
                        find_pair = True
                        break
                if not find_pair:
                    return False
        return len(stack) == 0