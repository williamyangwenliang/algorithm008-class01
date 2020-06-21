class Solution:
	#解题思路：双指针夹逼，判断字符为字母则交换位置
    def reverseOnlyLetters(self, S: str) -> str:
        s = list(S)
        left , right = 0, len(s)-1
        while left < right:
            while left < right and not s[left].isalpha():
                left += 1
            while left < right and not s[right].isalpha():
                right -= 1
            if left < right:
                s[left], s[right] = s[right], s[left]
                left += 1
                right -= 1
        return ''.join(s)