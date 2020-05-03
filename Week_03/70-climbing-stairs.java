class Solution {
    /**
     *解题思路：最简单的方法是直接递归返回结果，但这样会有很多重复的没必要的计算，
     *可以考虑将计算过的结果缓存起来，避免重复计算
     */
    public int climbStairs(int n) {
        //记录已经计算过的结果
        int[] record = new int[n];
        return helper(n, record);
    }

    private int helper(int n, int[] record) {
        if (n <= 2) return n;
        if (record[n - 2] == 0) record[n - 2] = helper(n - 1, record);
        if (record[n - 3] == 0) record[n - 3] = helper(n - 2, record);
        return record[n - 2] + record[n - 3];
    }
}