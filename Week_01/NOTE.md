# 							学习笔记·第一周

##### 感想：

​		第一次如此认真的开始系统性的学习数据结构与算法，以前大学时讲数据结构时都没怎么认真听课。。。以前总感觉算法和数据结构是比较高深难懂的东西，一直没敢主动去深入了解，怕被难住而退却。。。如今跟着课程一步步走下来，才发现原来这些并没有想象中难。经过几天的算法题目锻炼后也开始感觉逐渐上道了，虽然目前水平只能做些easy级的题目，不过这次不再恐惧，对未来的学习道路充满信心，希望自己能保持做题的习惯，坚持下去，早日攻克尽量多medium甚至是hard级的题目。

##### 总结：

###### 时间复杂度和空间复杂度

​	一个算法的优劣主要从算法的执行时间和所需要占用的存储空间两个方面衡量，这两点便是指时间复杂度和空间复杂度。我们一般用“大O符号表示法”来表示时间(空间)复杂度：T(n) = O(f(n))。

​	时间复杂度的计算并不是计算程序具体运行的时间，而是算法执行语句的次数。

​	常见的时间复杂度有：常数阶O(1), 对数阶O(logn), 线性阶O(n), 线性对数阶O(n logn), 平方阶O(n^2)，立方阶O(n^3)，k次方阶O(n^K),指数阶O(2^n)等。
​	随着n的不断增大，时间复杂度不断增大，算法花费时间越多。

​	空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度。

​	常见的空间复杂度有：常数阶O(1), 对数阶O(logn), 线性阶O(n), 线性对数阶O(n logn), 平方阶O(n^2)等。

###### 数据结构 

主要分为两大类，物理结构和逻辑结构

其中物理结构 为 顺序存储结构-数组 和 链式存储结构-链表。

逻辑结构是抽象的概念，它依赖于物理结构而存在，逻辑结构又可以分为线性结构和非线性结构两种；线性结构如 顺序表、栈和队列；非线性结构如树、图。

------

###### 数组

最常用的数据结构，在物理上表现为连续的存储块，特点是查找快O(1)，操作慢O(n)。

> 之前遍历字符串和数字时，总喜欢将其以字符串的形式split分割成数组，再迭代操作，数字还需要加一个字符串转数字的操作，加上Integer-int之间的装修拆箱操作，这样不仅耗空间，也特别耗时。建议遍历字符串改用toCharArray方法，单个字符比包含单个字符的字符串节省空间，比如'a'占一个字节，"a"占两个字节，因为每个字符串尾自动加一个'＼0'作为字符串结束标志；遍历数字则使用/10的方式分别求出余数即可。

###### 链表

链表不需要连续的存储块空间进行存储，由一系列节点组成，每个节点会存储当前节点的值和下一个节点的位置（双向链表多存储了上一个节点的位置），由于要存储其他节点的位置信息，所以在存储相同数据量的数据时，链表结构会比数组结构更耗费空间。特点是操作快O(1)，查找慢O(n)。

###### 跳表

跳表，是基于链表实现的一种类似“二分”的算法，链表加多级索引的结构，就叫做跳表。它可以快速的实现增，删，改，查操作。

跳表的 查询/更新 时间复杂度可以达到O(logn)。

![image-20200418215948629](C:\Users\William\AppData\Roaming\Typora\typora-user-images\image-20200418215948629.png)

###### 栈

栈(stack)作为一种数据结构，是一种只能在一端进行插入和删除操作的特殊线性表。先进后出。

> 一般递归算法都可以用栈的形式替换。

###### 队列

队列(queue)是一种特殊的线性表，特殊之处在于它只允许在表的前端(front)进行删除操作，而在表的后端(rear)进行插入操作，和栈一样，队列是一种操作受限制的线性表。

优先队列 (priority queue) 在队列的基础上加上排序的功能来调整数据的顺序，默认以自然顺序排序，也可以自定义比较器排序。

双端队列 (deque，全名double-ended queue)是一种具有队列和栈的性质的数据结构。双端队列中的元素可以从两端弹出，其限定插入和删除操作在表的两端进行。

------

- 用add first或add last这套新的API改写Deque的代码

  ```java
  Deque<String> deque = new LinkedList<String>();
  deque.add("a");
  deque.addFirst("b");
  deque.addLast("c");
  System.out.println("deque: " + deque);
  String peek = deque.peek();
  System.out.println("peek: " + peek);
  System.out.println("deque: " + deque);
  System.out.println("first: " + deque.getFirst());
  System.out.println("last: " + deque.getLast());
  while (deque.size()>0){
      System.out.println("pop: " + deque.pop());
  }
  System.out.println("deque: " + deque);
  ```

   结果：![image-20200418222541221](C:\Users\William\AppData\Roaming\Typora\typora-user-images\image-20200418222541221.png)

- 分析Queue和Priority Queue的源码

  现阶段的水平剖析源码略有压力，暂时借用网上大佬的：https://www.jianshu.com/p/8f8c15d57f6

  **add()和offer()**
  add(E e)和offer(E e)的语义相同，都是向优先队列中插入元素，只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后者则会返回false。对于PriorityQueue这两个方法其实没什么差别。新加入的元素可能会破坏小顶堆的性质，因此需要进行必要的调整。调整的过程为：从k指定的位置开始，将x逐层与当前点的parent进行比较并交换，直到满足x >= queue[parent]为止。注意这里的比较可以是元素的自然顺序，也可以是依靠比较器的顺序。

  **element()和peek()**
  element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null。根据小顶堆的性质，堆顶那个元素就是全局最小的那个；由于堆用数组表示，根据下标关系，0下标处的那个元素既是堆顶元素。所以直接返回数组0下标处的那个元素即可。

  **remove()和poll()**
  remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null。由于删除操作会改变队列的结构，为维护小顶堆的性质，需要进行必要的调整。其中的重点siftDown(int k, E x)方法，该方法的作用是从k指定的位置开始，将x逐层向下与当前点的左右孩子中较小的那个交换，直到x小于或等于左右孩子中的任何一个为止。

  **remove(Object o)**
  remove(Object o)方法用于删除队列中跟o相等的某一个元素（如果有多个相等，只删除一个），该方法不是Queue接口内的方法，而是Collection接口的方法。由于删除操作会改变队列结构，所以要进行调整；又由于删除元素的位置可能是任意的，所以调整过程比其它函数稍加繁琐。具体来说，remove(Object o)可以分为2种情况：1. 删除的是最后一个元素。直接删除即可，不需要调整。2. 删除的不是最后一个元素，从删除点开始以最后一个元素为参照调用一次siftDown()即可。此处不再赘述。

  ------

  ###### 本周算法题解析【格式为 LeetCode题号-题目标题】

  1. 1-two-sum

     ```java
     /**
       * 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
       *
       * 解题思路：因为a+b=target；所以a=targe-b；
       * 遍历数组nums[i]时把target把target-nums[i]存入hashSet中，
       * 如果nums[i]已存在于hashSet则说明找到符合条件的a和b
       */
      public int[] twoSum(int[] nums, int target) {
          int length = nums.length;
          HashMap<Integer, Integer> myMap = new HashMap<>(length - 1);
          for (int i = 0; i < length; i++) {
              if (myMap.containsKey(target - nums[i])) {
                  return new int[]{myMap.get(target - nums[i]), i};
              } else {
                  myMap.put(nums[i], i);
              }
          }
          return null;
      }
     ```

  2. 21-merge-two-sorted-lists

     ```java
     /**
      * Definition for singly-linked list.
      * public class ListNode {
      *     int val;
      *     ListNode next;
      *     ListNode(int x) { val = x; }
      * }
      */
     class Solution {
          /**
          * 题目：将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
          * 
          * 解题思路：因为是有序链表，所以直接比较2个链表的头结点的值，然后使用上一步较小值的下一个结点和另一个链表继续比较，使用递归方式解决即可
          */
         public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
             if(l1 == null){
                 return l2;
             } else if(l2 == null){
                 return l1;
             } else if(l1.val < l2.val){
                 l1.next = mergeTwoLists(l1.next,l2);
                 return l1;
             } else{
                 l2.next = mergeTwoLists(l1,l2.next);
                 return l2;
             }
         }
     }
     ```

  3. 26-remove-duplicates-from-sorted-array

     ```java
     /**
      *题目：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
      *
      *解题思路：由于不需要使用额外空间，使用一个变量记录调整后的数组下标，再直接使用新下标赋值覆盖原有值即可。由于原数组有序，所以如果有重复数字一定是连在一起的，利用这个特性，迭代旧数组的值，只复制一遍值到新下标，后面的重复值忽略。
      */
     public int removeDuplicates(int[] nums) {
         if(nums==null || nums.length==0) return 0;
         int a = 0;
         for (int i = 0; i < nums.length; i++) {
             if(nums[a]!=nums[i]){
                 nums[++a] = nums[i];
             }
         }
         return ++a;
     }
     ```

  4. 66-plus-one

     ```java
     /**
      *题目：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
      *最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
      *你可以假设除了整数 0 之外，这个整数不会以零开头。
      *
      *解题思路：如果数组末位数小于9，直接加1即可返回，如果=9，则需要进位，本位数改为0，对于类似9999....这种数据，则数组长度需要加1，并且首位数字为1，后面为0
      */
     public int[] plusOne(int[] digits) {
         for(int i=digits.length-1;i>=0;i--){
             if(digits[i] < 9){
                 digits[i]++;
                 return digits;
             } else{
                 digits[i]=0;;
             }
         }
     	//新数组只需要设置第一个数字即可，后面使用默认值0，因为+1后的结果到这里只能是100000......
         digits = new int[digits.length+1];
         digits[0]=1;
         return digits;        
     }
     ```

  5. 88-merge-sorted-array

     ```java
     /**
      *题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
      *初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
      *你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
      *
      *解题思路：因为是有序数组，而nums1数组后面有足够的空间，可以从数组后面开始倒序填入最大值，依次比较量数组末位即可。
      */
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         int len = m+n-1;
         int l1 = m-1;
         int l2 = n-1;
         while (l1>=0 && l2>=0){
             nums1[len--]=nums1[l1]>nums2[l2]?nums1[l1--]:nums2[l2--];
         }
     	//上面循环结束后如果l2>0，则说明nums2剩下的数全部小于nums1，直接复制即可
         System.arraycopy(nums2,0,nums1,0,l2+1);
     }
     ```

  6. 189-rotate-array

     ```Java
     /**
      *题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
      *
      *解题思路：
      *方法1：计算出元素需要移动的路径，用变量保存第一个值，然后让元素全部移动k个位置，直到第一个元素的下标等于next.next的下标即为移动结束；
      *方法2：根据原数组和结构数组的规律可知，先翻转整个数组，然后再分别翻转前k个数和后k个数即可得到结果数组
      */
     public void rotate1(int[] nums, int k) {
         if (k%nums.length==0) return;
     	k = k%nums.length;
         int count = 1;
         for(int i=0;count<nums.length;i++){
             int current= i;
             int nextVal = nums[i];
             do{
                 int next = (current+k)%nums.length;
                 int tmp = nums[next];
                 nums[next] = nextVal;
                 nextVal = tmp;
                 current = next;
                 count++;
             } while (i != current);
         }
     }
     public void rotate2(int[] nums, int k) {
         k = k%nums.length;
         if (k==0) return;
         reverse(nums,0,nums.length-1);
         reverse(nums,0,k-1);
         reverse(nums,k,nums.length-1);
     }
     
     private void reverse(int[] nums, int start, int end){
         while(start < end){
             int tmp = nums[start];
             nums[start] = nums[end];
             nums[end] = tmp;
             start++;
             end--;
         }
     }
     ```

  7. 283-move-zeroes

     ```java
     /**
      *题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
      *
      *解题思路：用一个变量保存移动后数组非0数字的下标，遍历原数组，将非0数字移动到新下标位置，并更新旧下标位置的值为0
      */
     public void moveZeroes(int[] nums) {
         int nz = 0;
         for(int i=0; i<nums.length; i++){
             if(nums[i]!=0){
                 if(i!=nz){
                     nums[nz] = nums[i];
                     nums[i] = 0;
                 }
                 nz++;
             }
         }
     }
     ```

  8. 641-design-circular-deque

     ```java
     /**
      *题目：设计实现双端队列。
      *你的实现需要支持以下操作：
      *MyCircularDeque(k)：构造函数,双端队列的大小为k。
      *insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
      *insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
      *deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
      *deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
      *getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
      *getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
      *isEmpty()：检查双端队列是否为空。
      *isFull()：检查双端队列是否满了。
      */
     class MyCircularDeque {
     
         private int[] ia;
         private int len = 0;
         private int k;
     
         /** Initialize your data structure here. Set the size of the deque to be k. */
         public MyCircularDeque(int k) {
             if(k < 0){
                 throw new RuntimeException("the Initialize size k must > 0.");
             }
             this.k = k;
             ia = new int[k];
         }
         
         /** Adds an item at the front of Deque. Return true if the operation is successful. */
         public boolean insertFront(int value) {
             if(len == k){
                 return false;
             } else{
                 for(int i=len;i>0;i--){
                     ia[i] = ia[i-1];
                 }
                 ia[0] = value;
                 len++;
                 return true;
             }
         }
         
         /** Adds an item at the rear of Deque. Return true if the operation is successful. */
         public boolean insertLast(int value) {
             if(len == k){
                 return false;
             } else{
                 ia[len] = value;
                 len++;
                 return true;
             }
         }
         
         /** Deletes an item from the front of Deque. Return true if the operation is successful. */
         public boolean deleteFront() {
             if(len == 0){
                 return false;
             } else{
                 for(int i=0;i<len-1;i++){
                     ia[i] = ia[i+1];
                 }
                 ia[len-1] = 0;
                 len--;
                 return true;
             }
         }
         
         /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
         public boolean deleteLast() {
             if(len == 0){
                 return false;
             } else{
                 ia[len-1] = 0;
                 len--;
                 return true; 
             }
         }
         
         /** Get the front item from the deque. */
         public int getFront() {
             if(len==0) {
                 return -1;
             } else{
                 return ia[0];
             } 
         }
         
         /** Get the last item from the deque. */
         public int getRear() {
             if(len==0) {
                 return -1;
             } else{
                 return ia[len-1];
             } 
         }
         
         /** Checks whether the circular deque is empty or not. */
         public boolean isEmpty() {
             return len==0;
         }
         
         /** Checks whether the circular deque is full or not. */
         public boolean isFull() {
             return len==k;
         }
     }
     
     /**
      * Your MyCircularDeque object will be instantiated and called as such:
      * MyCircularDeque obj = new MyCircularDeque(k);
      * boolean param_1 = obj.insertFront(value);
      * boolean param_2 = obj.insertLast(value);
      * boolean param_3 = obj.deleteFront();
      * boolean param_4 = obj.deleteLast();
      * int param_5 = obj.getFront();
      * int param_6 = obj.getRear();
      * boolean param_7 = obj.isEmpty();
      * boolean param_8 = obj.isFull();
      */
     ```

     