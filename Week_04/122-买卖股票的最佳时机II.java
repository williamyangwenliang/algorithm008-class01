class Solution {
    /**
     * 解题思路：遍历数组，当发现数组有上升趋势便进行买入，第二天抛出即可，
     * 相当于统计波动曲线中所有上升部分的总值
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) sum += (prices[i + 1] - prices[i]);
        }
        return sum;
    }
}