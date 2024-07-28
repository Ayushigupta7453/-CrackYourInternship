class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start =0;
        int value =0;
        int rem =0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            value += gas[i]-cost[i];
            if(value<0){
                rem += value;
                start = i+1;
                value =0;
            }
        }
        if(rem+value>=0){
            return start;
        }
        return -1;
    }
}
