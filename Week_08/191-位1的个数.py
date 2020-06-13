class Solution:
    '''
    解题思路：n = n & (n-1)这个操作会把n的二进制的末位1变成0，
    因此，while循环不断更新n值直到n==0即可算出n的二进制有几个1
    '''
    def hammingWeight(self, n: int) -> int:
        sum = 0
        while n != 0:
            sum += 1
            n &= n-1
        return sum
