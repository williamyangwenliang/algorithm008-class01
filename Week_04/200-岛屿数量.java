class Solution {
    /**
     * 解题思路：遍历矩阵，遇到0略过，遇到1则岛屿数量+1，并且把周围所有相邻的1置为0，
     * 这样在遍历一遍矩阵后即可得到岛屿数量
     */
    public int numIslands(char[][] grid) {
        int l1 = grid.length;
        if (l1 == 0) return 0;
        int l2 = grid[0].length;
        int count = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (grid[i][j] == '1') count++;
                dfs(grid, i, j, l1, l2);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int l1, int l2) {
        if (i < 0 || i >= l1 || j < 0 || j >= l2 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j, l1, l2);
        dfs(grid, i - 1, j, l1, l2);
        dfs(grid, i, j + 1, l1, l2);
        dfs(grid, i, j - 1, l1, l2);
    }
}