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
    int postpreindex=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            mp.put(postorder[i],i);
        }
        return helper(preorder,postorder,mp,0,postorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] postorder,HashMap<Integer, Integer> mp,int start, int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[postpreindex++]);
			

        if(start == end){
           return root;
        }
        int idx = mp.get(preorder[postpreindex]);
        root.left = helper(preorder,postorder,mp,start,idx);
        root.right = helper(preorder,postorder,mp,idx+1,end-1);
        return root;
    }
}
