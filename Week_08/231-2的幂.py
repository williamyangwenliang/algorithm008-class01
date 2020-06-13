class Solution:
    '''
    解题思路：2的幂次方在二进制里有且只有1个1，而n&(n-1)操作可以把n的二进制末位1变为0；
    故只需要判断n&(n-1)是否为0即可得出结果
    '''
    def isPowerOfTwo(self, n: int) -> bool:
        return n>0 and n&(n-1) == 0