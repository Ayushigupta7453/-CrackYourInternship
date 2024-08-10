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
    public int kthSmallest(TreeNode root, int k) {
    int[] ksmall = new int[1]; // Array to store ksmall value
    int[] c = new int[1]; // Array to store the count of visited nodes
    inorder(root, k, c, ksmall);
    return ksmall[0];
}

private void inorder(TreeNode root, int k, int[] c, int[] ksmall) {
    if (root == null || c[0] >= k) return;
    
    inorder(root.left, k, c, ksmall);
    
    c[0]++;
    if (c[0] == k) {
        ksmall[0] = root.val;
        return;
    }
    
    inorder(root.right, k, c, ksmall);
}

}
