import string
class Solution:
	'''
	解题思路：双向广度优先搜索，当beginSet和endSet产生交集时则得到结果
	每次只变动一个字母，遍历26个小写字母逐一替换即可
	'''
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if len(wordSet) == 0 or endWord not in wordSet: return 0
        beginSet = {beginWord}
        endSet = {endWord}
        res = 1
        length = len(beginWord)
        while beginSet:
            res += 1
            newSet = set()
            for b in beginSet:
                for i in range(length):
                    for c in string.ascii_lowercase:
                        if c == b[i]: continue
                        w = b[:i] + c + b[i+1:]
                        if w in endSet:
                            return res
                        if w in wordSet:
                            newSet.add(w)
                            wordSet.remove(w)
            beginSet = newSet
            if len(beginSet) > len(endSet):
                beginSet, endSet = endSet, beginSet
        return 0