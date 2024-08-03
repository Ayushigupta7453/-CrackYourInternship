
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
      int l = 0;
     
      for(int i=0;i<n;i++){
           int sum =0;
          for(int j=i;j<n;j++){
              sum += arr[j];
              if(sum==0){
                  if(l<j-i+1){
                      l = j-i+1;
                  }
              }
          }
      }
      return l;
    }
}
