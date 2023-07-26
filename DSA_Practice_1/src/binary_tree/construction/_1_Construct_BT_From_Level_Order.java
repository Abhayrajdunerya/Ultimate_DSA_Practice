package binary_tree.construction;

import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _1_Construct_BT_From_Level_Order {

    public static Node createTree(int []arr){
        if (arr == null || arr.length == 0) return null;
        int n = arr.length;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;
        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (i < n) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
                i++;
            }

            if (i < n) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
                i++;
            }

        }

        return root;
    }
    public static void main(String[] args) {
        
    }
}
