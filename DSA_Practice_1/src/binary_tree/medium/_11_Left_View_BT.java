package binary_tree.medium;

import java.util.ArrayList;
import binary_tree.BinaryTree.Node;

public class _11_Left_View_BT {

    public static void leftView_util(Node root, ArrayList<Integer> ans, int level) {
        if (root == null) return;
        
        if (ans.size() == level) {
            ans.add(root.data);
        }
        
        leftView_util(root.left, ans, level+1);
        leftView_util(root.right, ans, level+1);
    }
    
    public static ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> ans =new ArrayList<>();
        leftView_util(root, ans, 0);
        
        return ans;
    }
    public static void main(String[] args) {

    }
}
