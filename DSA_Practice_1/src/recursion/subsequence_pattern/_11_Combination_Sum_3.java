package recursion.subsequence_pattern;

import java.util.ArrayList;

public class _11_Combination_Sum_3 {

    public static void combiSum3(int n, int k, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int i) {

        if (n == 0 && k == ds.size()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (i > 9 || i > n || ds.size() > k) return;

        ds.add(i);
        combiSum3(n-i, k, ans, ds, i+1);
        ds.remove(ds.size()-1);

        combiSum3(n, k, ans, ds, i+1);
 
    }

    static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combiSum3(n, k, ans, new ArrayList<Integer>(), 1);

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
