class Solution {
    /**
     * 解题思路：dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 
     * 则递推式为: dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height+1][width+1];
        int maxSize = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]),dp[i][j]) + 1;
                    maxSize = Math.max(maxSize, dp[i+1][j+1]);
                }
            }
        }
        return maxSize * maxSize;
    }
}