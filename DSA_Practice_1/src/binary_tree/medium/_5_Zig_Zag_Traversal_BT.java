package binary_tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _5_Zig_Zag_Traversal_BT {

    ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> ans = new ArrayList<>();
	    if (root == null) return ans;
	    Queue<Node> q = new LinkedList<>();
	    boolean flag = true;
	    q.add(root);
	    
	    while (!q.isEmpty()) {
	        int numCountInLevel = q.size();
	        int ind = ans.size();
	        
	        for (int i = 0; i < numCountInLevel; i++) {
	            if (q.peek().left != null) q.add(q.peek().left);
	            if (q.peek().right != null) q.add(q.peek().right);
	            if (flag) {
	                ans.add(q.remove().data);
	            } else {
	               // ans.add(q.remove().data);
	                ans.add(ind, q.remove().data);
	            }
	        }
	        
	        flag = !flag;
	    }
	    
	    return ans;
	}
    
    public static void main(String[] args) {
        
    }
}
