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
     * 解题思路：如果根节点等于p或q，则说明共同祖节点为根节点，否则再按根节点的左右节点依次递归下去，
     * 如果左方向递归结果为null则返回右方向的结果，反之亦然，如果左右递归都不为null，则说明pq分别在两侧，则结果为root节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}