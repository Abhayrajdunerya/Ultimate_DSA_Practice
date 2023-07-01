package binary_tree.traversals;

import java.util.ArrayList;

import binary_tree.BinaryTree.Node;

public class _1_Preorder {

    public static void preorder_util(Node root, ArrayList<Integer> preorder) {
        if (root == null) return;

        preorder.add(root.data);
        preorder_util(root.left, preorder);
        preorder_util(root.right, preorder);
    }

    public static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();

        preorder_util(root, preorder);

        return preorder;
    }
    public static void main(String[] args) {
        
    }
}
