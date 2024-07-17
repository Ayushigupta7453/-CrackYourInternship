// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Approach 
// using 2 pointers and swap till all zeros are at end
class Solution {
    public void moveZeroes(int[] arr) {
        int j=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[j]==0 && arr[i]!=0){
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
    }
}