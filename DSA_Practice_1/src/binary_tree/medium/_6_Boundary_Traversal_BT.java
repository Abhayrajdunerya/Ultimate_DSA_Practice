package binary_tree.medium;

import java.util.ArrayList;

import binary_tree.BinaryTree.Node;

public class _6_Boundary_Traversal_BT {

    public static boolean isLeaf(Node node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
    
    public static void addLeaf(Node root, ArrayList<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        
        if (root.left != null) addLeaf(root.left, ans);
        if (root.right != null) addLeaf(root.right, ans);
    }
    
    public static void addLeft(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) ans.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    public static void addRight(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        for (int i = temp.size()-1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }
    
	public static ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if (node == null) return ans;
	    
	    if (!isLeaf(node)) ans.add(node.data);
	    
	    addLeft(node, ans);
	    addLeaf(node, ans);
	    addRight(node, ans);
	    
	    return ans;
	}
    public static void main(String[] args) {
        
    }
}
