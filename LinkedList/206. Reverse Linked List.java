/*https://leetcode.com/problems/reverse-linked-list/*/


//iterative way
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
             head=head.next;
             curr.next=prev;
             prev=curr;
             curr=head;
        }
        return prev;
    }

}
// recurrsive way
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
          if(head == null || head.next==null) {
            return head;
        }
    ListNode ans=  reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return ans;
    }

}
