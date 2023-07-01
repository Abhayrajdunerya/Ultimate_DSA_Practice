package binary_tree.medium;

import binary_tree.BinaryTree.Node;

public class _1_Check_BT_isBalanced {

    public static class Info {
        int height;
        boolean isBalance;

        Info(int ht, boolean balance) {
            this.height = ht;
            this.isBalance = balance;
        }
    }

    public static Info checkBalance(Node root) {
        if (root == null)
            return new Info(0, true);

        Info leftInfo = checkBalance(root.left);
        Info rightInfo = checkBalance(root.right);

        int diff = Math.abs(leftInfo.height - rightInfo.height);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        if (diff <= 1 && leftInfo.isBalance && rightInfo.isBalance) {
            return new Info(height, true);
        }

        return new Info(height, false);
    }

    public static boolean isBalanced(Node root) {
        // Your code here
        Info info = checkBalance(root);

        return info.isBalance;
    }

    public static void main(String[] args) {

    }
}
