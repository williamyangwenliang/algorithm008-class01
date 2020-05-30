class Solution {
    /**
     * 解题思路：推导状态转移方程，建立dp数组缓存递推过程结果，返回终点的递推结果即可
     * 状态转移方程为：def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j
     */
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] newNums = new int[length + 2];
        newNums[0] = 1;
        newNums[length + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, length);
        int[][] dp = new int[length + 2][length + 2];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 2; j < length + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }
        return dp[0][length + 1];
    }
}