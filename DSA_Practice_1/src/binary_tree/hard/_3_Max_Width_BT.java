package binary_tree.hard;

import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _3_Max_Width_BT {

    // LeetCode
    static class Pair {
        Node node;
        int num;
        Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static int widthOfBinaryTree(Node root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int width = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Node curr = q.peek().node;
                int curr_id = q.peek().num-min;

                q.remove();

                if (i == 0) first = curr_id;
                if (i == size-1) last = curr_id;

                if (curr.left != null) {
                    q.add(new Pair(curr.left, 2*curr_id+1));
                }
                if (curr.right != null) {
                    q.add(new Pair(curr.right, 2*curr_id+2));
                }
            }

            width = Math.max(width, last-first+1);
        }

        return width;
    }


    // --------------------------------------------------------------------------------------------------
    // GFG

    public static int getMaxWidth(Node root) {
        // Your code here
        int maxWidth = 0;
        if (root == null) return maxWidth;
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int countEleInALevel = q.size();
            maxWidth = Math.max(maxWidth, countEleInALevel);
            
            for (int i = 0; i < countEleInALevel; i++) {
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
                
                q.remove();
            }
        }
        
        return maxWidth;
    }
    public static void main(String[] args) {
        
    }
}
