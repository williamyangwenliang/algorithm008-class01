class Solution {
    /**
     * 解题思路：按列计算，每列左边的最高 与 右边的最高 中的最小值，与当前列的高度相减，如果大于0，则为当前列储存的雨水量
     */
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int sum = 0;
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = height[0];
        right[length-1] = height[length-1];
        for (int i = 1; i < length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = length - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 1; i < length - 1; i++) {
            int val = Math.min(left[i], right[i]) - height[i];
            if (val > 0) sum += val;
        }
        return sum;
    }
}