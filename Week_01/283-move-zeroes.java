
class Solution {
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