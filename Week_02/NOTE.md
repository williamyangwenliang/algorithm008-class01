# 学习笔记·第二周

##### 感想：

​	这周的内容比上周要难一些（往后应该越来越难的吧），显然需要花更多的时间去学习了，然而这周却不太有空，导致很多知识点没时间整理，知识吸收率也远不如上周，希望在后面自己能抽出时间补回这周落下的点，不能轻易掉队，也不能松懈。

------

##### 总结：

###### 哈希表

哈希表（Hash table，也叫散列表），是根据关键码值(Key value)而直接进行访问的数据结构。也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做哈希（散列）函数，存放记录的数组叫做散列表。

哈希函数的构造方法有很多种，如：直接定制法、直接定制法、平方取中法、折叠法、除留余数法等。其中除留余数法用的比较多，其处理过程为先计算key的hashcode，再模以存值数组的长度，便可得到下标值。但不管hash函数设计的如何巧妙，总会有特殊的key导致hash冲突。哈希冲突的解决方案也有很多，如：开放定制法、链地址法、公共溢出区法、再散列法等。其中链地址法使用较多，其处理过程为产生hash冲突后在存储数据后面加一个指针，指向后面冲突的数据。

哈希表的查找时间复杂度为O(1)。

###### 树、二叉树、图

树和图是典型的非线性结构。

树是由n（n>=0）个有限结点组成一个具有层次关系的集合。当n=0时，称为空树。在任意一个非空树中，有如下特点：

1. 有且仅有一个特定的点称为根的节点。

2. 当n>1时，其余节点可分为m个互不相交的有限集，每一个集合本身又是一个树，并称为根的子树。

   > 对于一颗树有三种遍历方式
   >
   > 1. 前序遍历：根-左-右
   > 2. 中序遍历：左-根-右
   > 3. 后序遍历：左-右-根

图（Graph）是由顶点的有穷非空集合和顶点之间边的集合组成，通常表示为：G(V,E)，其中，G表示一个图，V是图G中顶点的集合，E是图G中边的集合。在图中需要注意的是：

1. 线性表中我们把数据元素叫元素，树中将数据元素叫结点，在图中数据元素，我们则称之为顶点（Vertex）。

　2. 线性表可以没有元素，称为空表；树中可以没有节点，称为空树；但是，在图中不允许没有顶点。

　3. 线性表中的各元素是线性关系，树中的各元素是层次关系，而图中各顶点的关系是用边来表示（边集可以为空）。

BFS算法：Breadth-First-Search，宽度优先搜索；

DFS算法：Depth-first search，深度优先搜索;

###### jdk8 HashMap源码解析

（参考博文链接：https://www.cnblogs.com/wskwbog/p/10907457.html）

1. 基本结构

HashMap 基于散列表实现，使用拉链法处理碰撞，在 JDK8 中，当链表长度大于 8 时转为红黑树存储。

2. 散列函数

将整数散列最常用的方法就是除留余数法。为了均匀地散列键的散列值，通常都会把数组的大小取素数（HashTable 的初始大小就是 11），因为素数的因子少，余数相等的概率小，冲突的几率就小。HashMap 的容量始终是 2 的次幂，这是一个合数，之所以这样设计，是为了将取模运算转为**位运算**，提高性能。

3. put 操作

put 操作主要做了以下几件事：

```tex
1) 哈希桶数组 table 为空时，通过 resize() 方法进行初始化
2) 待插入的 key 已存在，直接覆盖 value
3) 若不存在，将键值对插入到对应的链表或红黑树中
4) 插入链表时判断是否转红黑树
5) 判断是否需要扩容
```
4. 扩容机制

默认情况下，初始容量是 16，负载因子是 0.75f，threshold 是 12，也就是说，插入 12 个键值对就会扩容。在扩容时，会扩大到原来的两倍，因为使用的是2的次幂扩展，那么元素的位置要么保持不变，要么在原位置上偏移2的次幂。

5. 链表转红黑树

链表转红黑树主要做了以下几件事：

```tex
1) 判断桶容量是否达到树化的最低要求，否则进行扩容
2) 将原链表转为由 TreeNode 组成的双向链表
3) 将新链表转为红黑树
```
