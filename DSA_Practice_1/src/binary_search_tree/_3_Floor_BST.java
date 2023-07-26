package binary_search_tree;

import binary_search_tree.BST.Node;

public class _3_Floor_BST {

    public static int floor(Node root, int key) {
        int ans = -1;
        while (root != null) {
            if (root.data == key) {
                ans = root.data;
                break;
            }
            
            if (root.data > key) {
                root = root.left;
            } else {
                ans = root.data;
                root = root.right;
            }
        }
        
        return ans;
    }

    public static int floor_recursive(Node root, int key) {
        if (root == null) return -1;
        if (root.data == key) return root.data;
        
        if (root.data > key) {
            return floor_recursive(root.left, key);
        } else {
            int ans = root.data;
            return Math.max(ans, floor_recursive(root.right, key));
        }
        
    }
    public static void main(String[] args) {
        
    }
}
