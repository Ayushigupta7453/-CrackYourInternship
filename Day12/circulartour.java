class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	   int n = petrol.length;
	   int value =0;
	   int rem =0;
	   int start =0;
	   for(int i=0;i<n;i++){
	       value += petrol[i]-distance[i];
	       if(value<0){
	           rem += value;
	           start = i+1;
	           value =0;
	       }
	   }
	   if(rem + value >=0){
	       return start;
	   }
	   return -1;
    }
}
