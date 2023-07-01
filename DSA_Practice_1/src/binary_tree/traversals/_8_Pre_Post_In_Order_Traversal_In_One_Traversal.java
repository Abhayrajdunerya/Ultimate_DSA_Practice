package binary_tree.traversals;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree.BinaryTree.Node;

public class _8_Pre_Post_In_Order_Traversal_In_One_Traversal {

    static class Pair {
        Node node;
        int num;
        Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static ArrayList<ArrayList<Integer>> preInPostOrder(Node root) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        
        if (root == null) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(pre);
            ans.add(in);
            ans.add(post);
            return ans;
        }

        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));

        while (!s.isEmpty()) {
            Pair temp = s.pop();

            if (temp.num == 1) {
                pre.add(temp.node.data);
                temp.num++;
                s.push(temp);
                if (temp.node.left != null) s.push(new Pair(temp.node.left, 1));
            } else if (temp.num == 2) {
                in.add(temp.node.data);
                temp.num++;
                s.push(temp);
                if (temp.node.right != null) s.push(new Pair(temp.node.right, 1));
            } else {
                post.add(temp.node.data);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(in);
        ans.add(post);

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
