package binary_tree.medium;

import binary_tree.BinaryTree.Node;

public class _12_Check_For_Symmetric_BT {

    public static boolean check(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        return (root1.data == root2.data && check(root1.left, root2.right) && check(root1.right, root2.left));
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        return check(root.left, root.right);
    }

    public static void main(String[] args) {

    }
}
