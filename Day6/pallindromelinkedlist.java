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
    public ListNode findmid(ListNode head){
           if(head == null || head.next == null) return head;
         
         ListNode curr = head;
         ListNode mid = head;
         while(curr.next != null && curr.next.next != null){
             curr = curr.next.next;
             mid = mid.next;
         }
         return mid;
     }
      public ListNode reverse(ListNode head){
         if(head == null || head.next == null) return head;
         
         ListNode curr = head, prev = null;
         while(curr != null){
             ListNode forw = curr.next;
             curr.next = prev;
             prev = curr;
             curr = forw;
         }
         return prev;
     }
     public boolean isPalindrome(ListNode head) {
        ListNode mid = findmid(head);
         ListNode halfList = reverse(mid.next);
         ListNode curr = head;
         
         while(halfList != null){
             if(curr.val != halfList.val) return false;
             curr = curr.next;
             halfList = halfList.next;
         }
         
         return true;
     }
 }