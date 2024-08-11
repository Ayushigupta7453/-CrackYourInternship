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
   
    public int maxPathSum(TreeNode root) {
      int max[] ={Integer.MIN_VALUE};
      findsum(root,max);
      return max[0]; 
    }
    public int findsum(TreeNode root, int[] max){
        if(root == null){
            return 0;

        }
        int leftMaxPath = Math.max(0, findsum(root.left, max));
        int rightMaxPath = Math.max(0, findsum(root.right, max));
        max[0]=Math.max(max[0],leftMaxPath + rightMaxPath + root.val);
        return Math.max(leftMaxPath,rightMaxPath)+root.val;
    }
}