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
    public ListNode swapPairs(ListNode head) {
        
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode temp=prev;
        ListNode first=new ListNode();
        ListNode second=new ListNode();
        
        while(temp.next!=null && temp.next.next!=null)
        {
            first=temp.next;
            second=first.next;
            first.next=second.next;
            second.next=first;
            temp.next=second;
            temp=first;
        }
        return prev.next;
    }
}