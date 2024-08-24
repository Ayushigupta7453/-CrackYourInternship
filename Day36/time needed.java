class Solution {
    HashMap<Integer,List<Integer>> tree;
    int helper(int cur,int[] time){
        int maxi=0;
        //IF NO SUBORDINATES TIME TAKEN TO SPEED NEWS IS 0
        if(!tree.containsKey(cur)){
            return 0;
        }
        //MAX DEPTH
        for(int x:tree.get(cur)){
            maxi=Math.max(maxi,helper(x,time)+time[cur]);
        }
        return maxi;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        tree=new HashMap<>();
        //TREE CONSTRUCTION USING HASHMAP
        for(int i=0;i<n;i++){
            tree.putIfAbsent(manager[i],new ArrayList<>());
            tree.get(manager[i]).add(i);
        }
        //MAX DEPTH (WITH TIME AS COST) IS THE ANSWER
        return helper(headID,informTime);
    }
}
