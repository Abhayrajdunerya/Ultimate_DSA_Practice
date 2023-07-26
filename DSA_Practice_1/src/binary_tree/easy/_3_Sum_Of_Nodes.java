package binary_tree.easy;

import binary_tree.BinaryTree.Node;

public class _3_Sum_Of_Nodes {

    public static int sumOfNodes(Node root) {
        if (root == null) return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum+rightSum+root.data;
    }
    public static void main(String[] args) {
        
    }
}
