/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        int size = 1;
        ListNode curr = head;

        while(curr.next != null){
            curr = curr.next;
            ++size; //LENGTH CALCULATION
        }
        curr.next = head;//MAKING CIRCULAR LIST

        int i = size - (k%size);//DISTNACE BETWEEN ORIGINAL HEAD THE POINT(CURR) WHERE THE LL WILL TERMINATE

        while(i>1){//LOOPING TO REACH TERMINATION POINT
            head = head.next;//THIS IS TERMINATION POINT
            i--;
        }

        curr = head.next;//SHIFTING ACTUAL HEAD TO NEW HEAD
        head.next = null;//TERMINATIN THE LL


        return curr;
    }    
}