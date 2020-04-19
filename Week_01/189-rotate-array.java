class Solution {
	/**
	 *题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
	 *
	 *解题思路：
	 *方法1：计算出元素需要移动的路径，用变量保存第一个值，然后让元素全部移动k个位置，直到第一个元素的下标等于next.next的下标即为移动结束；
	 *方法2：根据原数组和结构数组的规律可知，先翻转整个数组，然后再分别翻转前k个数和后k个数即可得到结果数组
	 */
    public void rotate(int[] nums, int k) {
        if (k%nums.length==0) return;
		k = k%nums.length;
        int count = 1;
        for(int i=0;count<nums.length;i++){
            int current= i;
            int nextVal = nums[i];
            do{
                int next = (current+k)%nums.length;
                int tmp = nums[next];
                nums[next] = nextVal;
                nextVal = tmp;
                current = next;
                count++;
            } while (i != current);
        }
    }

}