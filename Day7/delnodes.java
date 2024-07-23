class Solution
{
    Node compute(Node head)
    {
        // your code here
        if( head.next == null) {
        return head;
    }

    head.next = compute(head.next);
    if (head.data < head.next.data){
        return head.next;
    }
    
    return head;
    }
}
