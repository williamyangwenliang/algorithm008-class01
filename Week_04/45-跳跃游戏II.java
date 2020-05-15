class Solution {
    /**
     * 解题思路：贪心算法+动态规划；我们用 end 表示当前能跳的边界，并在边界范围内计算下一次跳跃的边界；
     * 这样每次跳跃都是能跳跃的最佳距离，最终得到最少步数；
     */
    public int jump(int[] nums) {
        int step = 0;
        //边界值，即跳跃最远位置下标
        int end = 0;
        //用于计算当前边界内能跳跃的最远距离，用于下一个边界值
        int max = 0;
        //注意这里i < nums.length - 1；因为i在第0位置已经实现步数加一，步数是提前计算的
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}