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