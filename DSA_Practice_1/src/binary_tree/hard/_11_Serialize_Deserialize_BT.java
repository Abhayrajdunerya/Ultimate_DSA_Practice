package binary_tree.hard;

import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _11_Serialize_Deserialize_BT {

    public static String serialize(Node root) {
        if (root == null)
            return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                sb.append("n ");
                continue;
            }

            sb.append(curr.data + " ");
            q.add(curr.left);
            q.add(curr.right);
        }

        return sb.toString();
    }

    public static Node deserialize(String data) {
        if (data == "")
            return null;
        Queue<Node> q = new LinkedList<>();
        String[] dataues = data.split(" ");

        Node root = new Node(Integer.parseInt(dataues[0]));
        q.add(root);

        for (int i = 1; i < dataues.length; i++) {
            Node parent = q.remove();

            if (!dataues[i].equals("n")) {
                Node left = new Node(Integer.parseInt(dataues[i]));
                parent.left = left;
                q.add(left);
            }
            if (!dataues[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(dataues[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
