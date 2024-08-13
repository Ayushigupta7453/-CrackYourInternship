class Solution {
    Node divide(Node head) {
        // code here
        Node dummy = new Node(0);
        Node dummy1 = new Node(1);
        Node dummyhead = dummy, dummy1head = dummy1;
        while(head!=null){
            if(head.data%2==0){
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
