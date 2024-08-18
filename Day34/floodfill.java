class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int col = image[sr][sc];
        if(col != color){
            dfs(image,sr,sc,col,color);
        }
        return image;
    }
    public void dfs(int[][] image, int r, int c, int col, int color){
        if(image[r][c]==col){
            image[r][c]=color;
            if(r>=1){
                dfs(image,r-1,c,col,color);
            }
            if(c>=1){
                dfs(image,r,c-1,col,color);
            }
            if(r+1 < image.length){
                dfs(image,r+1,c,col,color);
            }
            if(c+1 < image[0].length){
                dfs(image,r,c+1,col,color);
            }
        }
    }
}
