package recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.List;

public class _7_Combination_Sum_1 {

    public static void combSum_1(int arr[], List<List<Integer>> ans, List<Integer> ds, int i, int k) {
        if (i == arr.length) {
            if (k == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[i] <= k) {
            ds.add(arr[i]);
            combSum_1(arr, ans, ds, i, k-arr[i]);
            ds.remove(ds.size()-1);
        }

        combSum_1(arr, ans, ds, i+1, k);
    }
    public static List< List < Integer > > combSum(int []ARR, int B) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        combSum_1(ARR, ans, ds, 0, B);

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {13,3,2,17};
        System.out.println(combSum(arr, 14));
    }
}
