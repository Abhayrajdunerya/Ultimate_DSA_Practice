package recursion.subsequence_pattern;

import java.util.ArrayList;
import java.util.Collections;

public class _9_Subset_Sum_1 {

    public static void subSetSum1(int arr[], ArrayList<Integer> ans, int i, int sum) {
        if (i >= arr.length) {
            ans.add(sum);
            return;
        }

        subSetSum1(arr, ans, i+1, sum);
        subSetSum1(arr, ans, i+1, sum+arr[i]);
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> ans = new ArrayList<>();

        subSetSum1(num, ans, 0, 0);

        Collections.sort(ans);

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
