package binary_tree.hard;

import binary_tree.BinaryTree.Node;

public class _17_Transform_To_Sum_Tree {

    public static int transform(Node root) {
        if (root == null) return 0;

        int left = transform(root.left);
        int right = transform(root.right);
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        int data = root.data;

        root.data = left+newLeft+right+newRight;
        return data;
    }
    public static void main(String[] args) {
        
    }
}
