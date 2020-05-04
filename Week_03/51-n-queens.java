class Solution {
    /**
     * 解题思路：可以套用回溯算法的模板代码，只是判断违规情况稍微复杂，可独立一方法出来实现
     * 步骤：先制作一个n行n列的初始矩阵，然后逐步在每一行的每一列位置放入皇后Q并判断，
     * 然后行数+1进入下一个递归，回溯状态时将'Q'重置回'.'即可
     */
    private List<List<String>> nqList = new ArrayList<>();
    private int n;

    private void backTrack(char[][] tmp, int row) {
        if (row == n) addToResult(tmp);
        for (int col = 0; col < n; col++) {
            if (!isValid(tmp, row, col)) continue;
            tmp[row][col] = 'Q';
            backTrack(tmp, row + 1);
            tmp[row][col] = '.';
        }
    }

    private void addToResult(char[][] tmp) {
        List<String> sl = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            sl.add(new String(tmp[i]));
        }
        nqList.add(sl);
    }

    //这里因为是由上至下填充Q，因此只需要判断当前行的上面是否包含Q
    private boolean isValid(char[][] tmp, int row, int col) {
        //判断当前列是否已有Q
        for (int i = 0; i <= row; i++) {
            if (tmp[i][col] == 'Q') return false;
        }
        //判断左上角斜线是否已有Q
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tmp[i][j] == 'Q') return false;
        }
        //判断右上角斜线是否已有Q
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (tmp[i][j] == 'Q') return false;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] init = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(init[i], '.');
        }
        backTrack(init, 0);
        return nqList;
    }
}