package binary_tree.traversals;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree.BinaryTree.Node;

public class _6_Iterative_Postorder {

    public static ArrayList<Integer> postorder_1(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        s1.push(root);
        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            
            // ans.add(0, curr.data);
            s2.push(curr);
            
            if (curr.left != null) s1.push(curr.left);
            if (curr.right != null) s1.push(curr.right);
        }
        
        while (!s2.isEmpty()) {
            ans.add(s2.pop().data);
        }
        
        return ans;
    }
    
    public static ArrayList<Integer> postOrder(Node node) {
        // code here
        return postorder_1(node);
    }
    public static void main(String[] args) {
        
    }
}
