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