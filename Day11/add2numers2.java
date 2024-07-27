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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry=0;
        while(rl1 !=null || rl2 !=null||carry==1){
            int sum=0;
            if(rl1 !=null){
              sum+=rl1.val;
              rl1=rl1.next;
            }
            if(rl2 != null){
                sum+=rl2.val;
                rl2= rl2.next;
            }
            sum += carry;
            carry = sum/10;
            ListNode newnode = new ListNode(sum%10);
            temp.next = newnode;
            temp = temp.next;
        }
        ListNode ans = reverse(dummy.next);
        return ans;

    }
}
