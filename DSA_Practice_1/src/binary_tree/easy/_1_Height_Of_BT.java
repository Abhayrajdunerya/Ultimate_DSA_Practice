package binary_tree.easy;

import binary_tree.BinaryTree.Node;

public class _1_Height_Of_BT {

    public static int height(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh)+1;
    }
    public static void main(String[] args) {
        
    }
}
