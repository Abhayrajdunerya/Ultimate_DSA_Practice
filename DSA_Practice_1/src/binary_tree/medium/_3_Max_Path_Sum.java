package binary_tree.medium;

import binary_tree.BinaryTree.Node;

public class _3_Max_Path_Sum {

    public static int maxPathSum(Node root, int maxSum[]) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, maxPathSum(root.left, maxSum));
        int rightSum = Math.max(0, maxPathSum(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], root.data + leftSum + rightSum);

        return Math.max(leftSum, rightSum) + root.data;
    }

    public static int findMaxSum(Node node) {
        // your code goes here
        int maxSum[] = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSum(node, maxSum);

        return maxSum[0];
    }

    public static void main(String[] args) {

    }
}
