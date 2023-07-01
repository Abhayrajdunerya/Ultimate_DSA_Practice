package binary_tree.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree.BinaryTree.Node;

public class _10_Construct_BT_From_Postorder_Inorder {

    public static Node buildTreeUtil(int inorder[], int postorder[], int inStart, int inEnd, 
            int postStart, int postEnd, HashMap<Integer, Queue<Integer>> inMap) {
                
        if (inStart > inEnd || postStart > postEnd || inStart >= inorder.length || postStart >= postorder.length) return null;
        
        Node root = new Node(postorder[postEnd]);
        int inRoot = inMap.get(root.data).remove();
        
        root.left = buildTreeUtil(inorder, postorder, inStart, inRoot-1, postStart, postStart+inRoot-inStart-1, inMap);
        root.right = buildTreeUtil(inorder, postorder, inRoot+1, inEnd, postStart+inRoot-inStart, postEnd-1, inMap);
        
        return root;
    }
    
    Node buildTree(int in[], int post[], int n) {
        
        HashMap<Integer, Queue<Integer>> inMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            // inMap.put(in[i], i);
            
            if (inMap.get(in[i]) != null) {
                inMap.get(in[i]).add(i);
                inMap.put(in[i], inMap.get(in[i]));
            } else {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                inMap.put(in[i], q);
            }
        }
        
        return buildTreeUtil(in, post, 0, n-1, 0, n-1, inMap);
        
    }
    public static void main(String[] args) {
        
    }
}
