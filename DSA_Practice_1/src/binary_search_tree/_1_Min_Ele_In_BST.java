package binary_search_tree;

import binary_search_tree.BST.Node;

public class _1_Min_Ele_In_BST {

    int minValue(Node node) {
        if (node == null) return -1;
        if (node.left == null) return node.data;
        
        return minValue(node.left);
    }
    public static void main(String[] args) {
        
    }
}
