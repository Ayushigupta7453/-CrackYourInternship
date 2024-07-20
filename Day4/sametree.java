class Solution{
  public boolean issametree(TreeNode p, TreeNode q){
    if(p == null && q == null)  return true;
    if(p != null && q == null || p == null && q != null) return false;
    if(p.val != q.val) return false;
    return issametree(p.left,q.left) && issametree(p.right,q.right);
  }
}
