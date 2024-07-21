public class convertbintoint {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb=new StringBuilder();
       ListNode temp=head;
       while(temp!=null){
           sb.append(temp.val);
           temp=temp.next;
       }
       int decimal = Integer.parseInt(sb.toString(), 2);
       return decimal;
   }   
}
