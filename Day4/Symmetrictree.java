/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q ==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null ;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = invertTree(r);
        root.right = invertTree(l);
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
       TreeNode r = invertTree(root.left);
       if(isSameTree(r,root.right)){
           return true;

       }
       return false;
    }
}
