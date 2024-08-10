package Day26;

class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
       if (root == null) {
        return;
    }

    // If the key is found
    if (root.data == key) {
        // The maximum value in the left subtree is the predecessor
        if (root.left != null) {
            Node tmp = root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            pre[0] = tmp;
        }

        // The minimum value in the right subtree is the successor
        if (root.right != null) {
            Node tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            suc[0] = tmp;
        }
        return;
    }

    // If the key is smaller than the root's data, go to the left subtree
    if (root.data > key) {
        suc[0] = root;
        findPreSuc(root.left, pre, suc, key);
    }
    // If the key is greater than the root's data, go to the right subtree
    else {
        pre[0] = root;
        findPreSuc(root.right, pre, suc, key);
    }
}

}
