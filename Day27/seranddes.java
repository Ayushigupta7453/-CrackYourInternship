/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n == null){
                res.append("n ");
                continue;
            }
            res.append(n.val + " ");
            q.add(n.left);
            q.add(n.right);
        }
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String value[]= data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        q.add(root);
        for(int i=1;i<value.length;i++){
            TreeNode par = q.poll();
            if(!value[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                par.left = left;
                q.add(left);
            }
             if(!value[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                par.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
