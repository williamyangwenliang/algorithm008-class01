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