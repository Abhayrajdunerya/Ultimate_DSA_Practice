package binary_search_tree;

import binary_search_tree.BST.Node;

public class _9_Construct_BST_From_Preorder {

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            // left
            root.left = insert(root.left, val);
        } else {
            // right
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static Node buildBST(int pre[], int size) {
        if (size < 0)
            return null;

        Node root = null;

        for (int i = 0; i < size; i++) {
            root = insert(root, pre[i]);
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
