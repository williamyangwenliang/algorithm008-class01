class Solution {
    /**
     * 解题思路：如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
     * 如果能跳的最远距离小于0则失败，否则可以一直跳到最后，就成功了
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k - i < 0) return false;
            k = Math.max(k, nums[i] + i); // 这里+i对应上一行的-i，因为最远步数随着index的增加而减少
        }
        return true;
    }
}