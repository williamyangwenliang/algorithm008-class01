class Solution {
    /**
     * 解题思路：当前点的最短路径等于 自身路径 加 右节点的最短路径 或 下节点的最短路径
     * 递推方程为 dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                if (i == height - 1 && j == width - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == height - 1) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (j == width - 1) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
	
	//不使用额外空间缓存结果
	public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length;
        int width = grid[0].length;
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                if (i == height - 1 && j < width - 1) {
                    grid[i][j] = grid[i][j + 1] + grid[i][j];
                } else if (j == width - 1 && i < height - 1) {
                    grid[i][j] = grid[i + 1][j] + grid[i][j];
                } else if (i < height - 1 && j < width - 1) {
                    grid[i][j] = Math.min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
                }
            }
        }
        return grid[0][0];
    }
	
}