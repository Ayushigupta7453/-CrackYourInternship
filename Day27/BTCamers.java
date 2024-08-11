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
     class Pair<K, V> {
        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    int ans;
    public int minCameraCover(TreeNode root) {
        ans =0;
        if (find(root).second == 0) ans++;
        return ans;
    }
    private Pair<Integer, Integer> find(TreeNode root) {
        if (root == null) return new Pair<>(0, 1);

        Pair<Integer, Integer> left = find(root.left);
        Pair<Integer, Integer> right = find(root.right);

        if (left.second == 0 || right.second == 0) {
            ans++;
            return new Pair<>(1, 1);
        } else if (left.first == 1 || right.first == 1) {
            return new Pair<>(0, 1);
        } else {
            return new Pair<>(0, 0);
        }
    }
}
