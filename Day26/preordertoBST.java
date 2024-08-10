static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
     int[] indexPtr = {0};  // Use an array to simulate passing by reference
        return constructBST(pre, size, indexPtr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
private Node constructBST(int[] pre, int size, int[] indexPtr, int minVal, int maxVal) {
        // Base case: If all elements are used or the current element is out of bounds
        if (indexPtr[0] >= size) {
            return null;
        }

        Node root = null;
        int key = pre[indexPtr[0]];

        // If the current key is within the valid range, place it in the BST
        if (key > minVal && key < maxVal) {
            root = new Node(key);
            indexPtr[0] += 1;  // Move to the next element

            // Recursively construct the left and right subtrees
            if (indexPtr[0] < size) {
                root.left = constructBST(pre, size, indexPtr, minVal, key);
                root.right = constructBST(pre, size, indexPtr, key, maxVal);
            }
        }

        return root;
}}
