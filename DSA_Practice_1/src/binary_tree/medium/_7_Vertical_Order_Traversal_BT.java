package binary_tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _7_Vertical_Order_Traversal_BT {

    static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> verticalOrder(Node root) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Info> q = new LinkedList<>();

        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        int max = 0;
        int min = 0;

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (!map.containsKey(curr.hd)) {
                Queue<Integer> q2 = new LinkedList<>();
                q2.add(curr.node.data);
                map.put(curr.hd, q2);
            } else {
                Queue<Integer> q2 = map.get(curr.hd);
                q2.add(curr.node.data);
                map.put(curr.hd, q2);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }
            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            Queue<Integer> q2 = map.get(i);

            while (!q2.isEmpty()) {
                ans.add(q2.remove());
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
