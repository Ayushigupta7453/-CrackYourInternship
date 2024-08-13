class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Helper function to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Helper function to compare two linked lists
    private int compare(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data > temp2.data) return 1;
            if (temp1.data < temp2.data) return -1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 != null) return 1; // head1 is longer
        if (temp2 != null) return -1; // head2 is longer
        return 0; // Both are equal
    }

    // Function to subtract two linked lists
    public Node subLinkedList(Node head1, Node head2) {
        // Reverse both linked lists
        head1 = reverse(head1);
        head2 = reverse(head2);

        // Compare the two numbers
        if (compare(head1, head2) < 0) {
            // Swap the heads if head1 is smaller than head2
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        Node dummy = new Node(0);
        Node current = dummy;
        int borrow = 0;

        // Subtract the linked lists
        while (head1 != null) {
            int diff = head1.data - (head2 != null ? head2.data : 0) - borrow;

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            current.next = new Node(diff);
            current = current.next;

            head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        // Reverse the result list and remove leading zeros
        Node result = reverse(dummy.next);
        while (result != null && result.data == 0) {
            result = result.next;
        }

        return result != null ? result : new Node(0);
    }
}
