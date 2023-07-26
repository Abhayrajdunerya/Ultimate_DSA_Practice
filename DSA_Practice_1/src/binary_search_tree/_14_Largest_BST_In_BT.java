package binary_search_tree;

import binary_search_tree.BST.Node;

public class _14_Largest_BST_In_BT {

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static int maxBST = 0;

    public static Info getMaxBST(Node root) {
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info leftInfo = getMaxBST(root.left);
        Info rightInfo = getMaxBST(root.right);

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int size = leftInfo.size + rightInfo.size + 1;

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static int largestBst(Node root) {
        // Write your code here
        Info ans = getMaxBST(root);

        return maxBST;

    }

    public static void main(String[] args) {
        Node root = new Node(8);

        System.out.println(largestBst(root));
    }
}
