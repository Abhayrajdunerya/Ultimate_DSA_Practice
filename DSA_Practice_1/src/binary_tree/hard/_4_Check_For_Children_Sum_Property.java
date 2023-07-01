package binary_tree.hard;

import binary_tree.BinaryTree.Node;

public class _4_Check_For_Children_Sum_Property {

    static class Info {
        int num;
        boolean isTrue;

        Info(int num, boolean isTrue) {
            this.num = num;
            this.isTrue = isTrue;
        }
    }

    public static Info solve(Node root) {
        if (root == null)
            return new Info(0, true);
        if (root.left == null && root.right == null)
            return new Info(root.data, true);

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isTrue && right.isTrue && root.data == left.num + right.num)
            return new Info(root.data, true);

        return new Info(root.data, false);
    }

    public static int isSumProperty(Node root) {
        // add your code here
        Info ans = solve(root);

        return ans.isTrue ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
