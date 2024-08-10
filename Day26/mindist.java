class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = findLCA(root, a, b);
        
        // Calculate distance from LCA to node a and node b
        int distanceA = findDistance(lca, a, 0);
        int distanceB = findDistance(lca, b, 0);
        
        // Return the sum of both distances
        return distanceA + distanceB;
    }
    private Node findLCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        
        // If either a or b matches the root's key, this node is the LCA
        if (root.data == a || root.data == b) {
            return root;
        }
        
        // Look for keys in left and right subtrees
        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);
        
        // If both left and right subtrees contain a or b, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        
        // Otherwise, return the non-null child (either leftLCA or rightLCA)
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    
    private int findDistance(Node root, int val, int distance) {
        if (root == null) {
            return -1;
        }
        
        if (root.data == val) {
            return distance;
        }
        
        // Search in the left subtree
        int leftDistance = findDistance(root.left, val, distance + 1);
        if (leftDistance != -1) {
            return leftDistance;
        }
        
        // Search in the right subtree
        return findDistance(root.right, val, distance + 1);
    }
}
