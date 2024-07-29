class Solution {
    private int idx = 0;

    Node constructTree(int n, int pre[], char preLN[]) {
        idx = 0;
        return help(n, pre, preLN);
    }

    Node help(int n, int pre[], char preLN[]) {
        if (idx >= n) {
            return null;
        }
        Node temp = new Node(pre[idx]);
        if (preLN[idx] == 'N') {
            idx++;
            temp.left = help(n, pre, preLN);
            temp.right = help(n, pre, preLN);
        } else {
            idx++;
        }
        return temp;
    }
}
