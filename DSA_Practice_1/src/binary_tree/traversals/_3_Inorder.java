package binary_tree.traversals;

import java.util.ArrayList;

import binary_tree.BinaryTree.Node;

public class _3_Inorder {

    public static void inorder_util(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;

        inorder_util(root.left, inorder);
        inorder.add(root.data);
        inorder_util(root.right, inorder);
    }

    public static ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();

        inorder_util(root, inorder);

        return inorder;
    }
    
    public static void main(String[] args) {
        
    }
}
