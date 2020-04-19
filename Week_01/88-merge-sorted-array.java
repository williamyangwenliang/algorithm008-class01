class Solution {
	/**
	 *题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
	 *初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
	 *你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 *
	 *解题思路：因为是有序数组，而nums1数组后面有足够的空间，可以从数组后面开始倒序填入最大值，依次比较量数组末位即可。
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n-1;
        int l1 = m-1;
        int l2 = n-1;
        while (l1>=0 && l2>=0){
            nums1[len--]=nums1[l1]>nums2[l2]?nums1[l1--]:nums2[l2--];
        }
		//上面循环结束后如果l2>0，则说明nums2剩下的数全部小于nums1，直接复制即可
        System.arraycopy(nums2,0,nums1,0,l2+1);
    }
}