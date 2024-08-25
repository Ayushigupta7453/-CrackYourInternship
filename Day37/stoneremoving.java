class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
       List<Integer>[] adj = new List[n];
       for(int i=0;i<n;i++){
        adj[i]= new ArrayList<>();
       }

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] ||  stones[i][1] == stones[j][1]){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int conn = 0;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            vis[i] = false;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                conn++;
            }
        }
        return n-conn;
    }
    private void dfs( List<Integer>[] adj, boolean vis[], int idx){
        vis[idx]=true;
        for(int nbr: adj[idx]){
            if(!vis[nbr]){
                dfs(adj,vis,nbr);
            }
        }
    }
}
