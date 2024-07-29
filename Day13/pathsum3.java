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
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return pathSum(root.left,sum)+pathsum1(root,sum,0)+pathSum(root.right,sum);
    }
    public int pathsum1(TreeNode root, int sum,long curr){
        if(root == null){
            return 0;
        }
        int res =0;
        curr += root.val;
        if(curr == sum){
            res++;
        }
        res += pathsum1(root.left, sum,curr);
        res += pathsum1(root.right,sum,curr);
        return res;
    }
}
