/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 解题思路：中序遍历即遍历顺序为 左-根-右，利用递归即可，需要注意加上非空判断
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> itList = new ArrayList<>();
        if (root == null) return itList;
        if (root.left != null) helper(root.left, itList);
        itList.add(root.val);
        if (root.right != null) helper(root.right, itList);
        return itList;
    }

    private void helper(TreeNode node, List<Integer> itList) {
        if (node == null) return;
        helper(node.left, itList);
        itList.add(node.val);
        helper(node.right, itList);
    }
}