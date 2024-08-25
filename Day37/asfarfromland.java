class Solution {
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid == null || grid.length == 0) {
            return -1;
        }

        boolean vis[][] = new boolean[row][col];
        return bfs(vis, grid, row, col);
    }

    private int bfs(boolean vis[][], int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = -1;

        // Add all land cells to the queue
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        // If there is no water or no land, return -1
        if (q.isEmpty() || q.size() == row * col) {
            return -1;
        }

        // Perform BFS
        while (!q.isEmpty()) {
            int size = q.size();
            res++;  // Increase distance with each level of BFS

            while (size-- > 0) {
                int curr[] = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] d : dir) {
                    int newx = x + d[0];
                    int newy = y + d[1];

                    // Correct boundary checks and visited check
                    if (newx >= 0 && newy >= 0 && newx < row && newy < col && !vis[newx][newy]) {
                        vis[newx][newy] = true;
                        grid[newx][newy] = grid[x][y] + 1;
                        q.offer(new int[]{newx, newy});
                    }
                }
            }
        }

        return res;
    }
}
