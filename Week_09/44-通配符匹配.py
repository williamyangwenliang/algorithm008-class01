class Solution:
	#解题思路：本题主要看*字符的匹配情况，用2个指针分别记录*的位置。。。
    def isMatch(self, s: str, p: str) -> bool:
        iStar, jStar, i, j, sl, pl = -1, -1 , 0, 0, len(s), len(p)
        while i < sl:
            if j < pl and (s[i]==p[j] or p[j]=='?'):
                i += 1
                j += 1
            elif j < pl and p[j] == '*':
                iStar = i         
                jStar = j
                j += 1
            elif iStar >= 0:
                iStar += 1
                i = iStar
                j = jStar + 1
            else:
                return False
        while j < pl and p[j] == '*': j += 1
        return j == pl