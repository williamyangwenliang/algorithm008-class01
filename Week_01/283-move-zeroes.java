
class Solution {
	/**
	 *题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 *
	 *解题思路：用一个变量保存移动后数组非0数字的下标，遍历原数组，将非0数字移动到新下标位置，并更新旧下标位置的值为0
	 */
    public void moveZeroes(int[] nums) {
        int nz = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                if(i!=nz){
                    nums[nz] = nums[i];
                    nums[i] = 0;
                }
                nz++;
            }
        }
    }
}