/*https://leetcode.com/problems/reverse-nodes-in-k-group/*/

class Solution {
    public ListNode reverse(ListNode head,ListNode knode ){
        ListNode curr=head;
        if(head==null || head.next==null){
            return head;
        }
        ListNode ans=null;
        while(curr!=knode){
            ListNode next=curr.next;
            curr.next=ans;
            ans=curr;
            curr=next;
        }
        return ans;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head==null){
           return head;
       }
     ListNode curr=head;
    for(int i=0;i<k;i++){
        if(curr==null){
            return head;
        }
        curr=curr.next;
    }
    ListNode ans=reverse(head,curr);
    head.next=reverseKGroup(curr,k);
    return ans;
    }
}
