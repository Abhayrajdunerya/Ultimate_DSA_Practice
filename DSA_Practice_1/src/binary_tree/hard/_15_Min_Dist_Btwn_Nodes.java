package binary_tree.hard;

import binary_tree.BinaryTree.Node;

public class _15_Min_Dist_Btwn_Nodes {

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) return root;

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if (leftLca == null) return rightLca;
        if (rightLca == null) return leftLca;

        return root;
    }

    public static int lcaDist(Node root, int k) {
        if (root == null) return -1;
        if (root.data == k) return 0;

        int leftDist = lcaDist(root.left, k);
        int rightDist = lcaDist(root.right, k);

        if (leftDist == -1 && rightDist == -1) return -1;
        if (leftDist == -1) return rightDist+1;
        else return leftDist+1;
    }

    public static int minDist(Node root, int n1, int n2) {
        if (root == null) return -1;
        
        Node lca = lca(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1+dist2;
        
    }
    public static void main(String[] args) {
        
    }
}
