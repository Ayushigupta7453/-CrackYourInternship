/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       if(head == null){
        return null;
       }
       Node newhead = new Node(head.val);
       if(head.next == null){
          Node newo =  newhead;
          if(head.random == null){
            newhead.random = null;
          }
          else{
            newhead.random= newo;
          }
          return newhead;
       }
       Node temp = newhead;
       Node temp2 = head.next;
       while(temp2 != null){
        Node newone = new Node(temp2.val);
        temp.next = newone;
        temp = temp.next;
        temp2 = temp2.next;
       }
       temp2 = head;
       temp = newhead;
       while(temp2 != null){
        Node og = head;
        Node copy = newhead;
        if(temp2.random == null){
            temp.random = null;
        }
        else{
            while(og != temp2.random && copy.next != null){
                og = og.next;
                copy = copy.next;
            }
            temp.random = copy;
        }
        temp = temp.next;
        temp2 = temp2.next;
       }
       return newhead;
    }
}
