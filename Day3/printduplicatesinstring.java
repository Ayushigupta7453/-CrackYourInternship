class Solution{
  public static void duplicates(String s){
    Map<Character,Integer> mp = new HashMap<>();
    int n = s.length();
    for(int i=0;i<n;i++){
      if(mp.containsKey(s.charAt(i)){
         mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
    }
      else
        mp.put(s.charAt(i),1);
    }
    for(Map.Entry<Character,Integer> e : mp.entrySet()){
      if(e.getValue()>1){
        System.out.println(e.getKey() + ", count = " + e.getValue());
      }
    }
  }
}
