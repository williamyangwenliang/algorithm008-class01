class Solution {

    public void rotate(int[] nums, int k) {
        if (k%nums.length==0) return;
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