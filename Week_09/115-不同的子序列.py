class Solution:
    '''
    解题思路：由两个字符串分别为空字符串开始，逐步增加一个字符串向后递推，得出转态转移方程为
	s[j-1] == t[i-1]时 dp[i][j] = dp[i-1][j-1] + dp[i][j-1] 否则 dp[i][j] = dp[i][j-1]
    '''
    def numDistinct(self, s: str, t: str) -> int:
        ls, lt = len(s), len(t)
        dp = [[1]*(ls+1)] + [[0]*(ls+1) for _ in range(lt)]
        for i in range(1,lt+1):
            for j in range(1,ls+1):
                if s[j-1] == t[i-1]:
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
                else:
                    dp[i][j] = dp[i][j-1]
        return dp[-1][-1]