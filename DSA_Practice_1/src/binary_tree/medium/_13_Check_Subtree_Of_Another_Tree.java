package binary_tree.medium;

import binary_tree.BinaryTree.Node;

public class _13_Check_Subtree_Of_Another_Tree {

    public static boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.data != node2.data) return false;

        return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }

    public static boolean checkSubTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null) return false;

        if (root1.data == root2.data) {
            if (isIdentical(root1, root2)) return true;
        }

        return checkSubTree(root1.left, root2) || checkSubTree(root1.right, root2);
    }
    public static void main(String[] args) {
        
    }
}
