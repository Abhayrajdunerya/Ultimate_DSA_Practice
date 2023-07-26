package binary_search_tree;

import java.util.ArrayList;

import binary_search_tree.BST.Node;

public class _8_LCA_Of_BST {

    public static void findPath(Node root, int key, ArrayList<Node> path) {
        if (root == null) return;
        
        while (root != null) {
            if (root.data == key) {
                path.add(root);
                break;
            } 
            
            path.add(root);
            
            if (key < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        
        
    }
    
	public static Node LCA(Node root, int n1, int n2)
	{
        ArrayList<Node> n1Path = new ArrayList<>();
        ArrayList<Node> n2Path = new ArrayList<>();
        
        findPath(root, n1, n1Path);
        findPath(root, n2, n2Path);
        
        int n = n1Path.size();
        int m = n2Path.size();
        
        int i = 0;
        int j = 0;
        
        while (i < n && j < m) {
            if (n1Path.get(i) != n2Path.get(j)) {
                break;
            }
            i++;
            j++;
        }
        
        i--;
        
        if (i < 0) return null;
        
        return n1Path.get(i);
    }
    public static void main(String[] args) {
        
    }
}
