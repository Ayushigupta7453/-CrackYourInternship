class solution{
  public int rangesumBST(TreeNode root, int low, int high){
    if(root == null) return 0;
    int curr = (root.val>=low && root.val<=high)? root.val : 0;
    int leftsum = rangesumbst(root.left, low, high);
    int rightsum = rangesumbst(root.right,low,high);
    return curr + leftsum + rightsum;
  }
}
