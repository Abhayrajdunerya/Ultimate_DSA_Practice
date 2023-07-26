package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

import binary_search_tree.BST.Node;

public class _11_Merge_2_BSTs {

    public static void inorder(Node root, List<Integer> ans) {
        if (root == null) return;
        
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
    
    public static List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        inorder(root1, arr1);
        inorder(root2, arr2);
        
        List<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        int n = arr1.size();
        int m = arr2.size();
        
        while (i < n && j < m) {
            if (arr1.get(i) <= arr2.get(j)) {
                ans.add(arr1.get(i++));
            } else {
                ans.add(arr2.get(j++));
            }
        }
        
        while (i < n) ans.add(arr1.get(i++));
        while (j < m) ans.add(arr2.get(j++));
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
