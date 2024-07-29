/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private HashMap<TreeNode, TreeNode> parentMap;
    private List<Integer> result;
    private Set<TreeNode> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        result = new ArrayList<>();
        visited = new HashSet<>();

        // Build the parent map for each node
        buildParentMap(root, null);

        // Start BFS from the target node
        bfs(target, k);
        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

    private void bfs(TreeNode node, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);
        int currentDistance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().val);
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
            currentDistance++;
        }
    }
}
