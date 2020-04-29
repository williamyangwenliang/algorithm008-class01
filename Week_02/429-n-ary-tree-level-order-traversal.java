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
     * 解题思路：利用队列实现广度优先遍历，每次循环把所有的下一层节点添加到队列，在下一次循环再依次取出上一次存储的节点的值
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> loList = new ArrayList<>();
        if (root == null) return loList;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levelList.add(node.val);
                queue.addAll(node.children);
            }
            loList.add(levelList);
        }
        return loList;
    }
}