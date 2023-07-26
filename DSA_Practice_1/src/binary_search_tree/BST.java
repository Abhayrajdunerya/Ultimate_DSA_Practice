package binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    private int idx;

    BST() {
        this.root = null;
        this.idx = -1;
    }

    public Node buildTree_preorder(int arr[]) {
        idx++;
        if (arr[idx] == -1 || idx >= arr.length) return null;

        Node root = new Node(arr[idx]);
        root.left = buildTree_preorder(arr);
        root.right = buildTree_preorder(arr);

        return root;
    }

    public Node buildTree_levelorder(int arr[]) {
        int n = arr.length;
        Queue<Node> q = new LinkedList<>();

        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;
        while (!q.isEmpty()) {
            Node curr = q.remove();
            
            if (i < n && arr[i] != -1) {
                Node newNode = new Node(arr[i]);
                curr.left = newNode;
                q.add(newNode);
            }

            if (++i < n && arr[i] != -1) {
                Node newNode = new Node(arr[i]);
                curr.right = newNode;
                q.add(newNode);
            }

            i++;
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
