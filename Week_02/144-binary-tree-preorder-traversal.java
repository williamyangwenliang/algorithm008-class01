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
     *解题思路：前序遍历顺序为 根-左-右，使用递归遍历即可
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ptList = new ArrayList<>();
        if(root==null) return ptList;
        ptList.add(root.val);
        if(root.left!=null) helper(root.left, ptList);
        if(root.right!=null) helper(root.right, ptList);
        return ptList;
    }

    private void helper(TreeNode node, List<Integer> ptList){
        if(node==null) return;
        ptList.add(node.val);
        helper(node.left, ptList);
        helper(node.right, ptList);
    }
}