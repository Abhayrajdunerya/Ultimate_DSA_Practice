package binary_tree.medium;

import java.util.ArrayList;
import binary_tree.BinaryTree.Node;

public class _14_Kth_Level_Of_A_Tree {

    public static void solve_1(Node root, int k, ArrayList<Integer> ans) {
        if (root == null) return;

        if (k == 0) ans.add(root.data);
        solve_1(root.left, k-1, ans);
        solve_1(root.right, k-1, ans);
    }

    public static ArrayList<Integer> kthLevel(Node root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve_1(root, k, ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
