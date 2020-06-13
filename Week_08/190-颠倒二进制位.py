class Solution:
    '''
    解题思路：从正序的二进制末位数开始逐一遍历，分别获取该位置对应的颠倒位对应的值，累加即可
    '''
    def reverseBits(self, n: int) -> int:
        res, power = 0, 31
        #遍历直到n==0
        while n:
            #n&1得出最后二进制最后一位的值
            res += ((n&1) << power)
            n = n >> 1
            power -= 1
        return res
