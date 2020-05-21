# 学习笔记·第四周

##### 感谢：

​	有段时间发现自己解题速度明显快了不少，于是乎就开始飘飘然了，尤其是在不看题解解出中等甚至困难级别的题目时；结果在某天做一个简单级别的题目时都感觉寸步难行，顿时感觉当头棒喝！还是得虚心啊，算法题才做了几道，完全没达到骄傲的资本，继续加油吧少年。

##### 总结：

###### 深度优先搜索（Depth First Search，简称DFS）

一种用于遍历或搜索树或图的算法。 沿着树的深度遍历树的节点，尽可能深的搜索树的分支。当节点v的所在边都己被探寻过或者在搜寻时结点不满足条件，搜索将回溯到发现节点v的那条边的起始节点。整个进程反复进行直到所有节点都被访问为止。属于盲目搜索,最糟糕的情况算法时间复杂度为O(!n)。

```python
# dfs代码模板
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

###### 广度优先搜索（Breadth-First-Search，简称BFS）

是一种图形搜索算法。简单的说，BFS是从根节点开始，沿着树(图)的宽度遍历树(图)的节点。如果所有节点均被访问，则算法中止。BFS同样属于盲目搜索。一般用**队列**数据结构来辅助实现BFS算法。

```java
	//bfs代码模板 这里用二叉树的层序遍历做示例，先把每一层的所有值放入队列中，再遍历队列取出值
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //这里queue.size()不能写进for循环里，因为循环中会改变queue的长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(level);
        }
        return res;
    }
```

###### 贪心算法

所谓贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，它所做出的仅仅是在某种意义上的局部最优解。
贪心算法没有固定的算法框架，算法设计的关键是贪心策略的选择。必须注意的是，贪心算法不是对所有问题都能得到整体最优解，选择的贪心策略必须具备无后效性（即某个状态以后的过程不会影响以前的状态，只与当前状态有关。）

**贪心策略适用的前提是：局部最优策略能导致产生全局最优解。**
实际上，贪心算法适用的情况很少。一般对一个问题分析是否适用于贪心算法，可以先选择该问题下的几个实际数据进行分析，就可以做出判断。

```java
	//题目：LeetCode 455-分发饼干
	/**
     * 解题思路：给2个数组排序，先用小饼干喂胃口小的孩子，
     * 如果小饼干不够量，则移动指针，直到饼干派完或没有孩子需要饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi++;
            } 
            si++;
        }
        return gi;
    }
	//在以上的解法中，我们只在每次分配时饼干时选择一种看起来是当前最优的分配方法，但无法保证这种局部最优的分配方法最后能得到全局最优解。我们假设能得到全局最优解，并使用反证法进行证明，即假设存在一种比我们使用的贪心策略更优的最优策略。如果不存在这种最优策略，表示贪心策略就是最优策略，得到的解也就是全局最优解。
```

###### 二分查找

二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列。

```java
//二分查找示例代码
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; 

    while(left <= right) { // 这里是<=而不是<
        int mid = (right + left) / 2;
        if(nums[mid] == target)
            return mid; 
        else if (nums[mid] < target)
            left = mid + 1; 
        else if (nums[mid] > target)
            right = mid - 1; 
        }
    return -1;
}
```

思考题：使用二分查找，寻找一个半有序数组 （如[4, 5, 6, 7, 0, 1, 2]） 中间无序的地方

```java
    /**
     * 解题思路：二分查找法，定义左右指针和中间指针，如果左半部分有序则说明无序部分在右半部分，反之亦然；直到左右指针重合即找到无序下标
     */
    public int search(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        int left = 0;
        int right = nums.length - 1;
		int mid = (left + right) / 2;
		if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) return -1; //有序数组
        while (left <= right) {
            mid = (left + right) / 2;
            if (left == mid) return left; //左右指针重合，即该index为无序位置
            if (nums[right] > nums[mid]) { //说明右半部分有序，改变右指针
                right = mid;
            } else { //说明左半部分有序，改变左指针
                left = mid;
            }
        }
        return -1;
    }
```

