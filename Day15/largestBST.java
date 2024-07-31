class Nodeval{
    public int min,max,msize;
    Nodeval(int min, int max, int msize){
        this.min=min;
        this.max = max;
        this.msize = msize;
    }
}

class Solution{
    private static Nodeval helper(Node root){
        if(root == null){
            return new Nodeval(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Nodeval left = helper(root.left);
        Nodeval right = helper(root.right);
        if(left.max <root.data && root.data < right.min){
            return new Nodeval(Math.min(root.data, left.min), Math.max(root.data, right.max), left.msize+right.msize+1);
        }
        return new Nodeval(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.msize,right.msize));
        
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return helper(root).msize;
        
    }
