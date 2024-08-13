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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode dummy1 = new ListNode(0);
        ListNode dummyhead = dummy, dummy1head = dummy1;
        while(head != null){
            if(head.val<x){
              dummyhead.next = head;
              dummyhead = dummyhead.next;
            }
            else{
               dummy1head.next = head;
               dummy1head = dummy1head.next;
            }
            head = head.next;
        }
        dummy1head.next = null;
        dummyhead.next = dummy1.next;
        return dummy.next;
    }
}
