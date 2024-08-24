
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]= new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if (dfs(i, -1, vis, adj)) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int parent, boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        for(int nbr:adj.get(i)){
            if(!vis[nbr]){
                if(dfs(nbr,i,vis,adj)){
                    return true;
                }
            }
            else if(nbr != parent){
                return true;
            }
        }
        return false;
    }
}