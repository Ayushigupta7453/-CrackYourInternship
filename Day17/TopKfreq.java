class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        if(k==nums.length){
            return nums;
        }
        Map<Integer,Integer> mp = new HashMap<>();
        for(int n:nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1,n2)-> mp.get(n1)-mp.get(n2)
        );
        for(int n:mp.keySet()){
            pq.add(n);
            if(pq.size()>k) pq.poll();
        }
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll();
        }
        return ans;
    }
}
