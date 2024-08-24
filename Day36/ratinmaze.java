class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
         ArrayList<String> paths = new ArrayList<>();
         int n = mat.length;
        
        // Edge case: If start or end cell is blocked
        if (mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            paths.add("-1");
            return paths;
        }
        
        // Create a visited matrix
        boolean[][] visited = new boolean[n][n];
        
        // Start DFS from (0,0)
        dfs(mat, 0, 0, visited, "", paths, n);
        
        // Sort the paths lexicographically
        Collections.sort(paths);
        
        if (paths.isEmpty()) {
            paths.add("-1");
        }
        
        return paths;
    
    }
      private static boolean isSafe(int x, int y, int[][] mat, boolean[][] visited, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] == 1 && !visited[x][y]);
    }
    private static void dfs(int[][] mat, int x, int y, boolean[][] visited, String path, ArrayList<String> paths, int n) {
        // Base case: If we reach the destination
        if (x == n-1 && y == n-1) {
            paths.add(path);
            return;
        }
        
        // Mark the cell as visited
        visited[x][y] = true;
        
        // Define the possible movements
        int[] rowDir = {1, -1, 0, 0};
        int[] colDir = {0, 0, 1, -1};
        char[] directions = {'D', 'U', 'R', 'L'};
        
        // Explore all 4 possible directions
        for (int i = 0; i < 4; i++) {
            int newX = x + rowDir[i];
            int newY = y + colDir[i];
            
            // Check if the new cell is within bounds, not visited, and not blocked
            if (isSafe(newX, newY, mat, visited, n)) {
                // Recursively explore the new cell
                dfs(mat, newX, newY, visited, path + directions[i], paths, n);
                
                // Backtrack: Unmark the cell as visited
                visited[newX][newY] = false;
            }
        }
        
        // Unmark the cell as visited before going back
        visited[x][y] = false;
    }
}
