package binary_tree.traversals;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree.BinaryTree.Node;

public class _5_Iterative_Preorder {

    public static ArrayList<Integer> preordere_iterative(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        if (root == null) return preorder;
        Stack<Node> s = new Stack<>();
        
        s.push(root);
        
        while (!s.isEmpty()) {
            Node curr = s.pop();
            preorder.add(curr.data);
            
            if (curr.right != null) s.push(curr.right);
            if (curr.left != null) s.push(curr.left);
        }
        
        return preorder;
    }
    public static void main(String[] args) {
        
    }
}
