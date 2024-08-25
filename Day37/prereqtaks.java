 List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N];
        
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph and populate the in-degree array
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }
        
        // Queue for nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process the nodes in topological order
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If count equals N, all nodes were processed
        return count == N;
