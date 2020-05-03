class Solution {
    /**
     * 解题思路：依旧是穷举，记录路径和选择列表，这里需要多做一步的是去重，
     * 去重也就是剪枝，可通过画图法确定要减的是哪部分，不要忘了先给数组排序
     */
    private List<List<Integer>> res = new ArrayList<>();

    private void backTrack(int[] nums, int length, boolean[] used, LinkedList<Integer> tmp) {
        if (tmp.size() == length) res.add(new ArrayList<>(tmp));
        for (int i = 0; i < length; i++) {
            if (used[i]) continue;
            //这里加上!used[i - 1]这个条件剪枝比较完整，使用used[i - 1]亦可
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            tmp.add(nums[i]);
            used[i] = true;
            backTrack(nums, length, used, tmp);
            used[i] = false;
            tmp.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> tmp = new LinkedList<>();
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] used = new boolean[length];
        backTrack(nums, length, used, tmp);
        return res;
    }
}