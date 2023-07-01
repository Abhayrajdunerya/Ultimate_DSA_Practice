package binary_tree.traversals;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree.BinaryTree.Node;

public class _7_Iterative_Inorder {

    public static ArrayList<Integer> inorder_iterative(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        if (root == null) return inorder;
        Stack<Node> s = new Stack<>();
        
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                Node temp = s.pop();
                inorder.add(temp.data);
                root = temp.right;
            }
        }
        
        return inorder;
    }
    public static void main(String[] args) {
        
    }
}
