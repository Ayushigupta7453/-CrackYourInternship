class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(
            a->-(a[0]*a[0]+a[1]*a[1])
        ));
        for(int[] point:points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.toArray(new int[k][2]);
    }
}
