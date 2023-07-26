package binary_search_tree;

import binary_search_tree.BST.Node;

public class _4_Insert_A_Node_In_BST {

    public static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (root.data == key)
            return root;

        if (key < root.data) {
            // left
            root.left = insert(root.left, key);
        } else {
            // right
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
