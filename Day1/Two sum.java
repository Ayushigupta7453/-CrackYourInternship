// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        int n = nums.length;
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
            if((nums[i]+nums[j])==target&&i!=j){
                arr[0]=i;
                arr[1]=j;
            }
           }
        }
        return arr;
    }
}
