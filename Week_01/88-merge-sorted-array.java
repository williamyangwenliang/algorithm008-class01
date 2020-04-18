class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n-1;
        int l1 = m-1;
        int l2 = n-1;
        while (l1>=0 && l2>=0){
            nums1[len--]=nums1[l1]>nums2[l2]?nums1[l1--]:nums2[l2--];
        }
        System.arraycopy(nums2,0,nums1,0,l2+1);
    }
}