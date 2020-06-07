class Solution:
    '''
    解题思路：递推方程为 f(n) = f(n-1) + f(n-2)
        已知第一步的值为1，因此采用自顶向下的方式进行递推，
        这里使用变量pre和curr缓存中间结果
    '''
    def climbStairs(self, n: int) -> int:
        if n <= 2: return n
        pre = 1
        curr = 2
        for i in range(3,n+1):
            now = pre + curr
            pre = curr
            curr = now
        return curr