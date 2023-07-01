package binary_tree.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _6_Min_Time_Taken_To_Burn_BT {

    public static Node makeParentLinks(Node root, HashMap<Node, Node> map, int tg) {
        Queue<Node> q = new LinkedList<>();
        Node target = null;
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr.data == tg)
                target = curr;

            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return target;
    }

    public static int minTime(Node root, int target) {
        if (root == null)
            return 0;
        HashMap<Node, Node> parent = new HashMap<>();
        Node targetNode = makeParentLinks(root, parent, target);

        HashMap<Node, Boolean> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        vis.put(targetNode, true);

        int minTime = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean isAnyBurn = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                if (curr.left != null && vis.get(curr.left) == null) {
                    isAnyBurn = true;
                    vis.put(curr.left, true);
                    q.add(curr.left);
                }
                if (curr.right != null && vis.get(curr.right) == null) {
                    isAnyBurn = true;
                    vis.put(curr.right, true);
                    q.add(curr.right);
                }
                if (parent.get(curr) != null && vis.get(parent.get(curr)) == null) {
                    isAnyBurn = true;
                    vis.put(parent.get(curr), true);
                    q.add(parent.get(curr));
                }
            }

            if (isAnyBurn)
                minTime++;

        }

        return minTime;

    }

    public static void main(String[] args) {

    }
}
