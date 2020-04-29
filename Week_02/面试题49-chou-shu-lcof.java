class Solution {
    /**
     *解题思路：建立n长度的数组用于存储丑数，根据丑数只包含2/3/5因子的特性，
     *从第一个数逐步向上推下个数字，直到第n个丑数
     */
    public int nthUglyNumber(int n) {
        int[] una = new int[n];
        una[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            una[i] = Math.min(una[p2] * 2, Math.min(una[p3] * 3, una[p5] * 5));
            if (una[i] == una[p2] * 2) p2++;
            if (una[i] == una[p3] * 3) p3++;
            if (una[i] == una[p5] * 5) p5++;
        }
        return una[n - 1];
    }
}