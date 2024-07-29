package Day13;

class Solution
{
     static HashSet<Integer> allnodes;
    static HashSet<Integer> leafnodes;
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        if(root == null){
            return false;
        }
         allnodes = new HashSet<>();
         leafnodes = new HashSet<>();
        
       allnodes.add(0);
       storenodes(root);
       for(int i: leafnodes){
           int x = i;
           if(allnodes.contains(x+1) && allnodes.contains(x-1)){
               return true;
           }
       }
       return false;
        
    }
    public static void storenodes(Node root)
    {
        if (root == null)
            return;

        // store all node of binary search tree
        allnodes.add(root.data);

        // store leaf node in leaf_hash
        if (root.left == null && root.right == null) {
            leafnodes.add(root.data);
            return;
        }

        // recur call rest tree
        storenodes(root.left);
        storenodes(root.right);
    }
}