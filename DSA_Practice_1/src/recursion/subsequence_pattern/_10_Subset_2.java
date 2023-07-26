package recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_Subset_2 {

    public static void getUniqueSubsets(int arr[], List<List<Integer>> ans, List<Integer> ds, int idx) {
        ans.add(new ArrayList<Integer>(ds));

        for (int i = idx; i < arr.length; i++) {
            if (i != idx && arr[i] == arr[i-1]) continue;

            ds.add(arr[i]);
            getUniqueSubsets(arr, ans, ds, i+1);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getUniqueSubsets(nums, ans, new ArrayList<Integer>(), 0);

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
