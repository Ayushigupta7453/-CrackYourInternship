public class graphcoloring {
    static boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] && c == color[i])
                return false;
        return true;
    }

    // A recursive utility function to solve m coloring problem
    static boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v) {
        if (v == V)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;
                color[v] = 0;
            }
        }

        return false;
    }

    // This function solves the m Coloring problem using Backtracking.
    // It returns false if the m colors cannot be assigned, otherwise, return true
    // and prints assignments of colors to all vertices.
    static boolean graphColoring(boolean[][] graph, int m) {
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(color);
        return true;
    }
}
