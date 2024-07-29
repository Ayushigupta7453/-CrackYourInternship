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
    public List<List<Integer>> levelOrder(TreeNode root) {
          ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        q.add(root);
        while(q.size()>0){
            
            List<Integer> subAns = new ArrayList<Integer>();
            int size = q.size();
            while(size-- > 0){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                subAns.add(q.remove().val);
            }
            ans.add(subAns);
        }
        return ans;
    }
}
