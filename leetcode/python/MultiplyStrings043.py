class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 == '0' or num2 == '0':
            return '0'
        mul1 = ""
        mul2 = ""
        len1 = len(num1)
        len2 = len(num2)
        # we order the two numbers
        if len1 > len2:
            mul1 = num1
            mul2 = num2
        else:
            mul2 = num1
            mul1 = num2
        # update the len
        len1 = len(mul1)
        len2 = len(mul2)
        adding_list = list()
        for i in range(len2, 0, -1):
            # keep in mind that i is 1 larger than what we want 
            pointer = i - 1
            # the pointer point to num2 (shorter)
            # digit mul all digit in num1
            digit = ord(mul2[pointer]) - ord('0')
            adding_list.append(self.mul_all(num1=mul1, digit=digit, zeroes=(len2 - i)))
        print(adding_list)
        return self.add_all(adding_list=adding_list, max_len=(len1 + len2))

    # doing single multiplication
    def mul_all(self, num1, digit, zeroes):
        res = 0
        for i in range(len(num1), 0, -1):
            # same as above
            pointer = i - 1
            digit_num1 = ord(num1[pointer]) - ord('0')
            times_10 = len(num1) - i
            mul = digit_num1 * digit * (10 ** times_10)
            res += mul
        return str(res) + ('0' * zeroes)
             
    # adding all the multiplication result
    def add_all(self, adding_list, max_len):
        # add all in adding list
        res = '0' * max_len
        res_list = list(res)
        next_val = 0
        for i in range(max_len, 0, -1):
            pointer = i - 1
            reverse = max_len - i
            sum_val = next_val
            next_val = 0
            for num_str in adding_list:
                len_num = len(num_str)
                if reverse < len_num:
                    sum_val += ord(num_str[len_num - reverse - 1]) - ord('0')
                    if sum_val >= 10:
                        next_val += 1
                        sum_val -= 10
            res_list[pointer] = str(sum_val)
        res = ''.join(res_list)
        if res[0] == '0':
            res = res[1:]
        return res


res = Solution().multiply('9', '99')
print(res)