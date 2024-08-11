class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>((a,b)->b.getKey()-a.getKey());
        int max = Integer.MIN_VALUE;
        for(int point[]:points){
            while(!q.isEmpty() && point[0]-q.peek().getValue()>k){
                q.poll();
            }
            if(!q.isEmpty()){
                max = Math.max(max, point[0]+point[1]+q.peek().getKey());
            }
            q.offer(new Pair<Integer, Integer>(point[1]-point[0],point[0]));
        }
        return max;
    }
}
