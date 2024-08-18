

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
         ArrayList<Integer> ans = new ArrayList<>();
         for(int i=0;i<V;i++){
               if (!vis[i]) {
            dfsutil(i, adj, vis, ans);
        }
         }
         
         return ans;
    }
    private void dfsutil(int v, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> ans ){
        vis[v]=true;
        ans.add(v);
        for(Integer n:adj.get(v)){
            if(!vis[n]){
              dfsutil(n,adj,vis,ans);  
            }
        }
    }
}