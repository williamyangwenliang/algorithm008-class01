class Solution {
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