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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;
        ListNode tail = curr;
        
        while(curr != null) {
            int sum = 0;
            
            while(curr.val != 0) {
                sum += curr.val;
                curr = curr.next;
            }
            curr = curr.next;
            tail.val = sum;
            tail.next = curr;
            tail = curr;
        }
        return head.next;
    }
}