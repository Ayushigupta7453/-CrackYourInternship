class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         boolean arr[]=new boolean[nums.length+1];
        List<Integer> al=new ArrayList<>();
        for(int x:nums){
            if(arr[x])
                al.add(x);
            else
                arr[x]=!arr[x];
        }
        return al;
    }
}
