package binary_tree.hard;

import binary_tree.BinaryTree.Node;

public class _16_Kth_Ancestor_Of_Node {
    

    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) return -1;
        if (root.data == n) return 0;

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist, rightDist);

        if (max+1 == k) System.out.println(root.data); 

        return max+1;
    }
    public static void main(String[] args) {
        
    }
}
