class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int start=0,end=0;
        int min_diff = Integer.MAX_VALUE;
        for(int i=0;i+m-1<n;i++){
            int diff = a.get(i+m-1)-a.get(i);
            if(min_diff>diff){
                min_diff=diff;
                start = i;
                end = i+m-1;
            }
        }
        return a.get(end)-a.get(start);
    }
}
