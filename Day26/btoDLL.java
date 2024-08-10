class Solution
{
    Node prev = null,head = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	if(root == null){
	    return null;
	}
	convert(root);
	return head;
	
    }
    void convert(Node root){
         if (root == null) {
            return;
        }
        convert(root.left);
	if(prev== null){
	    head = root;
	}
	else{
	    root.left = prev;
	    prev.right = root;
	}
	prev = root;
	convert(root.right);
    }
}
