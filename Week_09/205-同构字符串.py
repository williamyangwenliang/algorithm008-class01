class Solution:
	#解题思路：利用字典存储s与t的字符间的对应关系，遍历字符查找是否有不符合规则的字符，没有则返回True
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_dict = {}
        for i in range(len(s)):
            if s[i] not in s_dict:
                if t[i] in s_dict.values():
                    return False
                s_dict[s[i]] = t[i]
            else:
                if t[i] != s_dict[s[i]]:
                    return False
        return True