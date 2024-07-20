class Tree
{
    public static float findMedian(Node root)
    {
        // code here.
        ArrayList<Float> ans = new ArrayList<>();
        inorder(ans,root);
        int start = 0;
        int end = ans.size()-1;
        float median;
       if(ans.size() %2 != 0){
            median = ans.get((ans.size())/2);
       }
       else{
           int n = ans.size();
           median = (ans.get(n/2)+ans.get(n/2-1))/2;
       }
       return median;
       
    }
    public static void inorder(ArrayList<Float> ans,Node root){
        if(root == null) return;
        inorder(ans,root.left);
        ans.add((float)root.data);
        inorder(ans,root.right);
    }
}
