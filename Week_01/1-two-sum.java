class Solution {
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }
        return null;
    }*/

   /**
     * 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
	 *
     * 解题思路：因为a+b=target；所以a=targe-b；
     * 遍历数组nums[i]时把target把target-nums[i]存入hashSet中，
     * 如果nums[i]已存在于hashSet则说明找到符合条件的a和b
     *
     * @param nums   数组
     * @param target 目标值
     * @return 符合条件的数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> myMap = new HashMap<>(length - 1);
        for (int i = 0; i < length; i++) {
            if (myMap.containsKey(target - nums[i])) {
                return new int[]{myMap.get(target - nums[i]), i};
            } else {
                myMap.put(nums[i], i);
            }
        }
        return null;
    }

}