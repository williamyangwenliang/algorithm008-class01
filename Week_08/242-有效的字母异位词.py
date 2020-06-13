class Solution:
    '''
    解题思路：因为此题设定只有小写字母，所以可以用一个26位长度初始值为0的数组来进行计数，
    字符的ASCII值减去‘a’得出下标，字符串s中每个字符出现时在对应数组下标位置+1，同理t的-1；
    最后再遍历用于计数的数组，只有全为0的情况才是异位词
    '''
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        count_list = [0] * 26
        for i in range(len(s)):
            count_list[ord(s[i])-97] += 1
            count_list[ord(t[i])-97] -= 1
        for c in count_list:
            if c < 0: return False
        return True