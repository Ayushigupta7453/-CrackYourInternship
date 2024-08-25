class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
         int[] key = new int[V];
        // To check if the vertex is included in MST
        boolean[] inMST = new boolean[V];
        // Priority queue to pick the minimum weight edge
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));

        // Initialize keys as infinite
        Arrays.fill(key, Integer.MAX_VALUE);

        // Start with vertex 0
        key[0] = 0;
        pq.add(new Pair(0, 0));

        // MST sum of weights
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            // Extract minimum weight edge
            Pair pair = pq.poll();
            int u = pair.vertex;

            // If the vertex is already in MST, skip it
            if (inMST[u]) continue;
            inMST[u] = true;

            // Add the edge weight to the MST sum
            mstWeight += pair.weight;

            // Traverse all the adjacent vertices of the extracted vertex
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // If v is not in MST and weight is smaller than the current key of v
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Pair(v, weight));
                }
            }
        }

        return mstWeight;
    }
}
class Pair {
        int vertex;
        int weight;
        
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
