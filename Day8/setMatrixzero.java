class Solution {
    public void setZeroes(int[][] matrix) {
           int n = matrix.length;
        int m = matrix[0].length;
        HashSet<Integer> setRows = new HashSet<>();
        HashSet<Integer> setColumns = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    setRows.add(i);
                    setColumns.add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (setRows.contains(i) || setColumns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
