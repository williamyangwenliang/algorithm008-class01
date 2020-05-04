class Solution {
    /**
     * 解题思路：双指针夹逼，取两端指针较矮的值乘指针宽度为容器面积，
     * 移动高度较矮的指针，再次计算新容器面积，每次遍历更新最大面积值
     */
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int newArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, newArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}