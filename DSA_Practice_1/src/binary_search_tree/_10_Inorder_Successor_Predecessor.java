package binary_search_tree;

import binary_search_tree.BST.Node;

public class _10_Inorder_Successor_Predecessor {

    public static Node successor(Node root, int key) {
        if (root == null)
            return null;

        Node ans = null;
        while (root != null) {
            if (key < root.data) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ans;
    }

    public static Node predecessor(Node root, int key) {
        if (root == null)
            return null;

        Node ans = null;
        while (root != null) {
            if (key <= root.data) {
                root = root.left;
            } else {
                ans = root;
                root = root.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
