class Solution {
    /**
     * 解题思路：此类问题一般用穷举的解法，分别记录路径和选择列表，在达到条件后回溯状态；
     * 因为需要记录前面的选择，可以用集合自带的contains判断，但此方法实际复杂度较高；因而使用标记位是更好的选择
     */
    private List<List<Integer>> returnList = new ArrayList<>();

    private void backTrack(int[] nums, int length, boolean[] used, Stack<Integer> stack) {
        if (stack.size() == length){
            returnList.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            stack.add(nums[i]);
            used[i] = true;
            backTrack(nums, length, used, stack);
            //状态回溯
            used[i] = false;
            stack.pop();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        //标记元素是否已使用，初始值都为false
        boolean[] used = new boolean[nums.length];
        backTrack(nums, nums.length, used, stack);
        return returnList;
    }
}