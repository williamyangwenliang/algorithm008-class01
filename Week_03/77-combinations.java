class Solution {
    /**
     * 解题思路：回溯思想列出所有可能结果值，达到错误值时再沿路返回，
     * 利用递归操作实现，同时需注意剪枝
     */
    private List<List<Integer>> resultList = new ArrayList<>();

    private void recall(int n, int k, int start, Stack<Integer> stack) {
        if (stack.size() == k) {
            resultList.add(new ArrayList<>(stack));
            return;
        }
        //这里不做剪枝的话是i<=n，但是这里i在第n-(k-stack.size())+1个数后便无法再生成有效结果，剪枝去掉多余操作
        for (int i = start; i <= n - (k - stack.size()) + 1; i++) {
            stack.add(i);
            recall(n, k, i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k < 1) return resultList;
        recall(n, k, 1, new Stack<>());
        return resultList;
    }
}