package Day29;

import org.w3c.dom.Node;

public class zigzaglist {
     static void zigZagList(Node head) {
        boolean flag = true;
        Node curr = head;
        while(curr!=null && curr.next!=null){
            if(flag == true){
                if(curr.data>curr.next.data){
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            else{
                if(curr.data<curr.next.data){
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            curr = curr.next;
            flag = !(flag);
        } 
    }
}
