package binary_tree.hard;

import java.util.Stack;

import binary_tree.BinaryTree.Node;

public class _14_Flatten_BT_To_LinkedList {

    static Node prev = null;

    public static void flatten_recursive(Node root) {
        if (root == null)
            return;

        flatten_recursive(root.right);
        flatten_recursive(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flatten_iterative(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node curr = s.pop();
            if (curr.right != null)
                s.push(curr.right);
            if (curr.left != null)
                s.push(curr.left);
            if (!s.isEmpty())
                curr.right = s.peek();
            curr.left = null;
        }
    }

    public static void flatten(Node root) {
        flatten_recursive(root);
        // flatten_iterative(root);
    }

    public static void main(String[] args) {

    }
}
