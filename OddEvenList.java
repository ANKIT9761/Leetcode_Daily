// link- https://leetcode.com/problems/odd-even-linked-list/description/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode curr1=head,head1=head;
        ListNode curr2=head.next,head2=head.next;
        while(curr2!=null && curr2.next!=null){

            curr1.next=curr2.next;
            curr1=curr1.next;

            curr2.next=curr1.next;
            curr2=curr2.next;
        }
        curr1.next=head2;
        return head1;
    }
}
