package binary_search_tree;

import binary_search_tree.BST.Node;

public class _7_Check_IsBST_Or_BT {

    
    public static boolean checkBST(Node root, Node min, Node max) {
        if (root == null) return true;

        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return checkBST(root.left, min, root) && checkBST(root.right, root, max);
    }
    
    public static void main(String[] args) {

    }
}
