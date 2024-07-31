class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
         Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });
        boolean result[]=new boolean[n];
        for(int i=0;i<n;i++){
            result[i]=false;
        }
        int s[]=new int[n];
        for(int i=0;i<n;i++){
            for (int j = Math.min(n, arr[i].deadline) - 1; j >= 0; j--) {
                // Free slot found
                if (!result[j]) {
                    result[j] = true;
                    s[j] = i;
                    break;
                }
            }
        }
         int countJobs = 0, maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (result[i]) {
                countJobs++;
                maxProfit += arr[s[i]].profit;
            }
        }
        int ans[]= new int[2];
        ans[0]=countJobs;
        ans[1]=maxProfit;
        return ans;
    }
}
