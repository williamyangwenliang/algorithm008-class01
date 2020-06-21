class Solution:
	# 解题思路：把字符串转list，每隔2k长度就反转k个字符，最后将list转为字符串返回
    def reverseStr(self, s: str, k: int) -> str:
        sl = list(s)
        for i in range(0, len(sl), 2 * k):
            sl[i:i+k] = reversed(sl[i:i+k])
        return ''.join(sl)