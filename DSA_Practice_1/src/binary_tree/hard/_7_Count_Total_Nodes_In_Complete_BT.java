package binary_tree.hard;

import binary_tree.BinaryTree.Node;

public class _7_Count_Total_Nodes_In_Complete_BT {

    public static int leftHeight(Node root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        
        return h;
    }
    
    public static int rightHeight(Node root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }
        
        return h;
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;
        
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        
        if (lh == rh) return (1 << lh)-1;
        
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        
        return leftNodes+rightNodes+1;
    }
    public static void main(String[] args) {
        
    }
}
