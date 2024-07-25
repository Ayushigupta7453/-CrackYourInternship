class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top=0;
        int bottom= m;
        int left=0;
        int right=n;
          int  k;
          int total =0;
        List<Integer> list = new ArrayList<>();
        while(top<m && left<n){
          
            for(k=left;k<right && total<m*n;k++){
                list.add(matrix[top][k]);
                total++;
            }
            top++;
          
            for(k=top;k<bottom && total<m*n;k++){
                list.add(matrix[k][right-1]);
             total++;
            }
            right--;
            for(k=right-1;k>=left && total<m*n;k--){
                list.add(matrix[bottom-1][k]);
                total++;
            }
            bottom--;
            for(k=bottom-1;k>=top && total<m*n;k--){
                list.add(matrix[k][left]);
                total++;
            }
            left++;
        }
        return list;

    }
}
