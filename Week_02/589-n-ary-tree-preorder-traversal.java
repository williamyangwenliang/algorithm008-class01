/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
	/**
	 *解题思路：利用递归，逐一获取 根-左-右 节点的值
	 */
    public List<Integer> preorder(Node root) {
        List<Integer> nums = new ArrayList<>();
        if(root==null) return nums;
        helper(root, nums);
        return nums;
    }

    private void helper(Node node, List<Integer> nums){
        nums.add(node.val);
        for(Node n:node.children){
            helper(n, nums);
        }
    }
}