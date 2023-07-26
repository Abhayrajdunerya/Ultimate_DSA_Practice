package binary_search_tree;

import binary_search_tree.BST.Node;

public class _5_Delete_A_Node_In_BST {

    public static Node inorderSuccessor(Node root) {
        if (root == null) return null;
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
    
    public static Node deleteNode(Node root, int X) {
        if (root == null) return null;
        
        if (X < root.data) {
            // left
            root.left = deleteNode(root.left, X);
        } else if (X > root.data) {
            // right
            root.right = deleteNode(root.right, X);
        } else {
            // case - 1 - No Child
            if (root.left == null && root.right == null) return null;
            
            // case - 2 - 1 Child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // case - 3 - 2 Child
            Node IS = inorderSuccessor(root);
            root.data = IS.data;
            
            root.right = deleteNode(root.right, IS.data);
        }
        
        return root;
    }
    public static void main(String[] args) {
        
    }
}
