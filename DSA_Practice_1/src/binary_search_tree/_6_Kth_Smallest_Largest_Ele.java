package binary_search_tree;

import binary_search_tree.BST.Node;

public class _6_Kth_Smallest_Largest_Ele {

    static int count = 0;
    public static Node kthSmallest_rec(Node root, int k) {
        if (root == null) return null;

        Node left = kthSmallest_rec(root.left, k);
        if (left != null) return left;
        count++;
        if (count == k) return root;
        return kthSmallest_rec(root.right, k);
    }

    public static int kthSmallest(Node root, int k) {
        Node ans = kthSmallest_rec(root, k);
        return ans == null ? -1 : ans.data;
    }

    public static void main(String[] args) {
        int tree_levelorder[] = {5,3,6,2,4,-1,-1,1};
        // int tree_levelorder[] = {2, 1, 3, -1, -1, -1, 4, -1, -1};

        BST tree = new BST();
        tree.root = tree.buildTree_levelorder(tree_levelorder);
        BST.inorder(tree.root);
        System.out.println();
        
        System.out.println(kthSmallest(tree.root, 3));
    }
}
