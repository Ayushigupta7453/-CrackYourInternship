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
class BSTIterator {
     private List<Integer> nodes;
    private int index;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        index = -1; 
        inorderTraversal(root);
    }
    
    public int next() {
         index++;
        return nodes.get(index);
    }
    
    public boolean hasNext() {
       return index + 1 < nodes.size(); 
    }
     private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        nodes.add(root.val);
        inorderTraversal(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
