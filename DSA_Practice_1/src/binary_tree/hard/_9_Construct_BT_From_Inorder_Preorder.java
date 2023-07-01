package binary_tree.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _9_Construct_BT_From_Inorder_Preorder {

    public static Node buildTreeUtil(int inorder[], int preorder[], int inStart, int inEnd, 
            int preStart, int preEnd, HashMap<Integer, Queue<Integer>> inMap) {
                
        if (inStart > inEnd || preStart > preEnd || inStart >= inorder.length || preStart >= preorder.length) return null;
        
        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.data).remove();
        
        int numsLeft = inRoot-inStart;
        
        root.left = buildTreeUtil(inorder, preorder, inStart, inRoot-1, preStart+1, preStart+numsLeft, inMap);
        root.right = buildTreeUtil(inorder, preorder, inRoot+1, inEnd, preStart+numsLeft+1, preEnd, inMap);
        
        return root;
    }
    
    public static Node buildTree(int inorder[], int preorder[], int n) {
        // HashMap<Integer, Integer> inMap = new HashMap<>();
        HashMap<Integer, Queue<Integer>> inMap = new HashMap<>();
        
        
        for (int i = 0; i < n; i++) {
            // inMap.put(inorder[i], i);
            
            if (inMap.get(inorder[i]) != null) {
                inMap.get(inorder[i]).add(i);
                inMap.put(inorder[i], inMap.get(inorder[i]));
            } else {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                inMap.put(inorder[i], q);
            }
        }
        
        return buildTreeUtil(inorder, preorder, 0, n-1, 0, n-1, inMap);
    }
    public static void main(String[] args) {
        
    }
}
