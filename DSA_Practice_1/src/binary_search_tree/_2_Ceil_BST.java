package binary_search_tree;

import binary_search_tree.BST.Node;

public class _2_Ceil_BST {

    public static int ceil(Node root, int key) {
        int ans = -1;
        while (root != null) {
            if (root.data == key) {
                ans = root.data;
                break;
            }
            
            if (root.data < key) {
                root = root.right;
            } else {
                ans = root.data;
                root = root.left;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
