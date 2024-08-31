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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();
        for(int x:nums) st.add(x);
        // ListNode head=null;
        // ListNode tail=null;
        ListNode ptr=head;
        while(ptr!=null && st.contains(ptr.val))
        {
            ptr=ptr.next;
        }
        head=ptr;
        while(ptr!=null && ptr.next!=null)
        {
            while(ptr.next!=null && st.contains(ptr.next.val)){
                ptr.next=ptr.next.next;
            }
            ptr=ptr.next;
        }
        return head;


    }
}