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
     * 解题思路：前序遍历的第一个数字为根节点的值，找到该值对应的中序遍历的下标，
     * 便可划分出根节点的左子树和右子树，使用递归即可依次找到后面节点对应的位置
     */
    private Map<Integer, Integer> inorMap = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        for (int i = 0; i < inorder.length; i++) {
            inorMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int lindex, int rindex) {
        if (lindex > rindex) return null;
        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);
        Integer index = inorMap.get(val);
        node.left = helper(preorder, inorder, lindex, index - 1);
        node.right = helper(preorder, inorder, index + 1, rindex);
        return node;
    }
}