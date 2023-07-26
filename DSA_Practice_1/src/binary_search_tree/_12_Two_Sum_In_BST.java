package binary_search_tree;

import java.util.ArrayList;

import binary_search_tree.BST.Node;

public class _12_Two_Sum_In_BST {

    public static void inorder(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
    
    public static boolean targetSum(Node root, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        
        int i = 0, j = arr.size()-1;
        
        while (i < j) {
            int sum = arr.get(i)+arr.get(j);
            
            if (sum == target) return true;
            
            if (sum < target) i++;
            else j--;
        }
        
        return false;
    }
    public static void main(String[] args) {
        
    }
}
