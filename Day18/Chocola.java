class Solution{
  public static void main(String[] args){
    int n=4,m=6;
    int[] costver={2,1,3,6};
    int[] costhor = {5,7,8};
    Arrays.sort(costver,Collections.reverseOrder());
    Arrays.sort(costhor,Collections.reverseOrder());
    int h=0,v=0,hp=0,vp=0;
    while(h<costhor.length && v<costver.length){
      if(costver[v]<=costhor[h]){
        cost += costhor[h]*vp;
        hp++;
        h++;
      }
      else{
        cost += costver[v]*hp;
        vp++;
        v++;
      }
    }
    while(h<costhor.length){
      cost+=costhor[h]*vp;
      hp++;
      h++;
    }
    while(v<costver.length){
      cost += costver[v]*hp;
      vp++;
      v++;
    }
    System.out.println(cost);
  }
}
