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
 public class Solution{
      public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        int level = height(root)+1;
        for(int i=0;i<level-1;i++){
            ans.add(100);

        }
        preorder(root,ans,1);
        return ans;
    }
    public void preorder(TreeNode root,List<Integer> ans,int level){
        if(root == null){
            return;
        }
        ans.set(level-1,root.val);
        preorder(root.left,ans,level+1);
        preorder(root.right,ans,level+1);
    }
}
