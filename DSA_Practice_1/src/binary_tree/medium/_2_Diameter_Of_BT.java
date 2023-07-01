package binary_tree.medium;

import binary_tree.BinaryTree.Node;

public class _2_Diameter_Of_BT {

    public static class Info {
        int height;
        int diam;

        Info(int height, int diam) {
            this.height = height;
            this.diam = diam;
        }
    }

    public static Info diam(Node root) {
        if (root == null)
            return new Info(0, 0);

        Info leftInfo = diam(root.left);
        Info rightInfo = diam(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int diameter = Math.max(leftInfo.height + rightInfo.height + 1, Math.max(leftInfo.diam, rightInfo.diam));

        return new Info(height, diameter);
    }

    public static int diameter(Node root) {
        Info info = diam(root);
        return info.diam;
    }

    public static void main(String[] args) {

    }
}
