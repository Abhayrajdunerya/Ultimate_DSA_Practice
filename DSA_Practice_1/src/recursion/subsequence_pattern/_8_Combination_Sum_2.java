package recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.Collections;

public class _8_Combination_Sum_2 {

    public static void combSum2(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int idx, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            if (i > idx && arr.get(i) == arr.get(i-1)) continue;
            if (arr.get(i) > k) break;

            ds.add(arr.get(i));
            combSum2(arr, ans, ds, i+1, k-arr.get(i));
            ds.remove(ds.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        combSum2(arr, ans, new ArrayList<Integer>(), 0, target);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
