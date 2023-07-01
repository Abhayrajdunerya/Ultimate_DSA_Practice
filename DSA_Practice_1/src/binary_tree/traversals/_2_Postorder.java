package binary_tree.traversals;

import java.util.ArrayList;

import binary_tree.BinaryTree.Node;

public class _2_Postorder {

    public static void postorder_util(Node root, ArrayList<Integer> postorder) {
        if (root == null) return;

        postorder_util(root.left, postorder);
        postorder_util(root.right, postorder);
        postorder.add(root.data);
    }

    public static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> postorder = new ArrayList<>();

        postorder_util(root, postorder);

        return postorder;
    }
    public static void main(String[] args) {
        
    }
}
