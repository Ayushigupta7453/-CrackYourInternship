
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[]= new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, int vis[],ArrayList<ArrayList<Integer>> adj ){
        vis[node]=1;
        for(int nbr:adj.get(node)){
            if(vis[nbr]==0){
                if(dfs(nbr,vis,adj)){
                    return true;
                }
            }
            else if(vis[nbr]==1){
                return true;
            }
            
        }
        vis[node]=2;
        return false;
    }
}