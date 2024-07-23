public void sortlist(Node head){
    int count[]={0,0,0};
   Node current = head;
   while(current != null){
     count[current.data]++;
     current = current.next;
   }
  current = head;
  int i=0;
  while(current != null){
    if(count[i]==0){
      i++;
    }
    else{
      current.data=i;
      count[i]--;
      current = current.next;
    }
  }
}
