class Solution {
    //解法1：哈希表计数，计数到超过一般数量则返回
     public int majorityElement1(int[] nums) {
         Map<Integer, Integer> recMap = new HashMap<>();
         int length = nums.length;
         for (int i = 0; i < length; i++) {
             recMap.put(nums[i], recMap.getOrDefault(nums[i], 0) + 1);
             if (recMap.get(nums[i]) > length / 2) return nums[i];
         }
         return 0;
     }

    //解法2：因为这里的众数超过一半，所以取排序后的数组中间位置值即众数
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	//解法3
	/**
     * 解题思路：摩尔投票法，count为计数器，遇候选数+1，其他数-1；
     * 因为这里的众数过半，所以最后计数器一定大于0；
     * 选定第一个数为候选数，当count==0时更换候选数，留到最后的候选数为众数
     */
    public int majorityElement3(int[] nums) {
        int tmp = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) tmp = nums[i];
            count += nums[i] == tmp ? 1 : -1;
        }
        return tmp;
    }
}