package recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

public class _3_Print_All_Subsequences_PowerSet {

    public static void getSubsets(List<List<Integer>> ans, List<Integer> ds, int arr[], int i) {
        if (i >= arr.length) {
            ans.add(new ArrayList<Integer>(ds));
            System.out.println(ds);
            return;
        }

        getSubsets(ans, ds, arr, i+1);

        ds.add(arr[i]);
        getSubsets(ans, ds, arr, i+1);
        ds.remove(ds.size()-1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        getSubsets(ans, new ArrayList<Integer>(), nums, i);

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};

        subsets(arr);
    }
}
