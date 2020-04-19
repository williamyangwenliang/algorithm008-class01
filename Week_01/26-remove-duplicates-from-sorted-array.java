class Solution {
	/**
	 *题目：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 *不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	 *
	 *解题思路：由于不需要使用额外空间，使用一个变量记录调整后的数组下标，再直接使用新下标赋值覆盖原有值即可。
	 *由于原数组有序，所以如果有重复数字一定是连在一起的，利用这个特性，迭代旧数组的值，只复制一遍值到新下标，后面的重复值忽略。
	 */
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[a]!=nums[i]){
                nums[++a] = nums[i];
            }
        }
        return ++a;
    }
}