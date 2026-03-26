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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        temp=head;
       ListNode temp1=head;
        int[] answer=new int[count];
        int i=0;
        while(temp!=null){
            temp1=temp.next;
            answer[i]=0;
            while(temp1!=null){
                if(temp1.val>temp.val){
                answer[i]=temp1.val;
                break;
                }
                temp1=temp1.next;

            }
            i++;
            temp=temp.next;
        }
        return answer;
    }
}