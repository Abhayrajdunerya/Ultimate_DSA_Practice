package binary_tree.medium;

import binary_tree.BinaryTree.Node;

public class _4_Check_Two_Tree_Are_Identical {

    public static boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null || root1.data != root2.data)
            return false;

        if (!isIdentical(root1.left, root2.left))
            return false;
        if (!isIdentical(root1.right, root2.right))
            return false;

        return true;
    }

    public static void main(String[] args) {

    }
}
