class Solution {
    /**
     * 解题思路：这里要形成括号，所以字符串累加过程中')'出现的次数不能大于'('，因为只有左右括号两种字符，
     * 所以分别以左右括号进入递归路径，在 达到目标值或产生不符合规则的值 时进行回溯或剪枝
     */
    private List<String> gpList = new ArrayList<>();

    private void backTrack(int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) gpList.add(sb.toString());
        //剪枝
        if (left < right) return;
        if (left < n) {
            sb.append('(');
            backTrack(n, left + 1, right, sb);
            //回溯状态
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n) {
            sb.append(')');
            backTrack(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backTrack(n, 0, 0, sb);
        return gpList;
    }
}