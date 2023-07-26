package binary_tree.easy;

import binary_tree.BinaryTree.Node;

public class _2_Count_Nodes {

    public static int countNodes(Node root) {
        if (root == null) return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1+leftCount+rightCount;
    }

    public static void main(String[] args) {
        
    }
}
