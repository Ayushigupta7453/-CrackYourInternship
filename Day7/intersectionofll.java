public class intersectionofll {
    public int length(ListNode node){
        
        ListNode curr = node;
        int len=0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
        
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode A = headA;
        ListNode B = headB;
        
        int lenA = length(A);
        int lenB = length(B);
        
        int diff = Math.abs(lenA-lenB);
        
        ListNode longestList = lenA > lenB? A : B;
          while(diff-- > 0){
            
            longestList = longestList.next;
            
        }
        
        ListNode curr = lenA > lenB ? B : A;
        while(curr!= null && longestList != null){
            if(curr == longestList) return curr;
            curr = curr.next;
            longestList = longestList.next;
        }
        
        return null;
    }

}
