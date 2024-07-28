class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        // code here
        //brute force approach
        int knowme[]= new int[n];
        int iknow[]=new int[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==1){
                    knowme[j]++;
                    iknow[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(knowme[i]==n-1 && iknow[i]==0){
                return i;
            }
        }
        return -1;
    }
}
