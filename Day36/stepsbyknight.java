class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // Initial position of the knight
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        
        // Target position of the knight
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;
        
        // Base case: If the knight is already at the target position
        if (startX == targetX && startY == targetY) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        
        // Visited matrix to track visited cells
        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;
        
        // BFS to find the shortest path
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            
            // Try all 8 possible moves for a knight
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // Check if the new position is within the bounds and not visited
                if (isValidMove(newX, newY, N, visited)) {
                    // Check if the new position is the target position
                    if (newX == targetX && newY == targetY) {
                        return steps + 1;
                    }
                    
                    // Mark as visited and add to the queue
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, steps + 1});
                }
            }
        }
        
        // If we exhaust all possibilities without finding the target
        return -1;
    }

    // Method to check if a move is valid
    private static boolean isValidMove(int x, int y, int N, boolean[][] visited) {
        return (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]);
    
    }
}
