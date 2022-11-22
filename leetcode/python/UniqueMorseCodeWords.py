class Solution(object):
    def uniqueMorseRepresentations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        mos_list = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        asca = ord('a')
        cat_list = []
        for word in words:
            cat = ''
            for c in word:
                seq = mos_list[ord(c) - asca]
                cat += seq
            if cat not in cat_list:
                cat_list.append(cat)
        return len(cat_list)