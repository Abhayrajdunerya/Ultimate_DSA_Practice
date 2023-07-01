package binary_tree.hard;

import java.util.ArrayList;

import binary_tree.BinaryTree.Node;

public class _1_Root_To_Node_Path_BT {

    public static void getPaths(Node root, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) return;
        
        ds.add(root.data);
        
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(ds));
        }
        
        getPaths(root.left, ds, paths);
        getPaths(root.right, ds, paths);
        
        ds.remove(ds.size()-1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        getPaths(root, ds, paths);
        
        return paths;
    }
    
    public static void main(String[] args) {
        
    }
}
