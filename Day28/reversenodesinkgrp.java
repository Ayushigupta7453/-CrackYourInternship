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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevlast = null;
        while(temp!=null){
            ListNode knode = getknode(temp,k);
            if(knode == null){
                if(prevlast!=null){
                    prevlast.next = temp;
                }
                break;
            }
            ListNode nextnode = knode.next;
            knode.next = null;
            reverselist(temp);
            if(temp == head){
                head = knode;
            }
            else{
                prevlast.next = knode;
            }
            prevlast = temp;
            temp = nextnode;
        }
        return head;
    }
    public ListNode reverselist(ListNode head){
      ListNode temp = head;
      ListNode prev = null;
      while(temp!=null){
         ListNode front = temp.next;
         temp.next = prev;
         prev = temp;
         temp = front;
      }
      return prev;
    }
    public ListNode getknode(ListNode head,int k){
         ListNode temp = head;
         k-=1;
         while(k>0&&temp!=null){
            k--;
            temp = temp.next;
         }
         return temp;
    }
}
