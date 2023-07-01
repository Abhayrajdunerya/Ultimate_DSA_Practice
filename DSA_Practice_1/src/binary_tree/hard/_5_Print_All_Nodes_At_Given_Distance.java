package binary_tree.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _5_Print_All_Nodes_At_Given_Distance {

    public static Node makeParentLinks(Node root, HashMap<Node, Node> map, int k) {
        Queue<Node> q = new LinkedList<>();
        Node target = null;
        q.add(root);
        while (!q.isEmpty()) {
            Node parent = q.remove();

            if (parent.data == k) {
                target = parent;
            }

            if (parent.left != null) {
                map.put(parent.left, parent);
                q.add(parent.left);
            }
            if (parent.right != null) {
                map.put(parent.right, parent);
                q.add(parent.right);
            }
        }

        return target;

    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        HashMap<Node, Node> parent = new HashMap<>();
        HashMap<Node, Boolean> vis = new HashMap<>();
        Node targetNode = makeParentLinks(root, parent, target);

        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        vis.put(targetNode, true);
        int currLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (currLevel == k)
                break;
            currLevel++;

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                if (curr.left != null && vis.get(curr.left) == null) {
                    q.add(curr.left);
                    vis.put(curr.left, true);
                }
                if (curr.right != null && vis.get(curr.right) == null) {
                    q.add(curr.right);
                    vis.put(curr.right, true);
                }
                if (parent.get(curr) != null && vis.get(parent.get(curr)) == null) {
                    q.add(parent.get(curr));
                    vis.put(parent.get(curr), true);
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.remove().data);
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

    }
}
