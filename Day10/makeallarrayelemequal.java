public class Solution{
  public int computecost(int[] arr){
    int ans =0;
    Arrays.sort(arr);
    for(int i=1;i<arr.length;i++){
      ans += Math.abs(arr[i]-arr[i-1]);
    }
    return ans;
  }
}
