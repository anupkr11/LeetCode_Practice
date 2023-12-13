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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // while(head==null || head.next == null){
        //     return null;
        // }
        // ListNode dummy = new ListNode();
        // dummy.next = head;
        // ListNode slow = dummy;
        // ListNode fast = dummy;
        // for(int i=0; i<n; i++){
        //     fast = fast.next;
        // }
        // while(fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        // // if(slow==dummy)
        // // return head.next;
        // slow.next = slow.next.next;
        // return dummy.next;
        ListNode curr = head;
        int size = 0;
        
        if(head.next == null){
            return null;
        }
        
        
        while(curr!=null){
            curr = curr.next;
            size++;
        }
        
        if(n==size) return head.next;
        int indSearch = size-n;
        ListNode prev = head;
        int i=1;
        while(i<indSearch){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}