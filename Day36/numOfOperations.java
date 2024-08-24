class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }

        boolean vis[] = new boolean[n];
        int comp = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                comp++;
            }
        }
        return comp - 1;
    }
    public void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, vis, adj);
            }
        }
    }
}
