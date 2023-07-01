package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _6_Merge_Overlapping_SubIntervals {

    // Brute - O(N*logN) + O(2*N), O(N)
    public static List<List<Integer>> mergeInterval_brute(int arr[][]) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr, Comparator.comparingDouble(O -> O[0]));

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)) {
                continue;
            }

            for (int j = i+1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }

    // Optimal - O(N*logN) + O(N), O(N)
    public static List<List<Integer>> mergeInterval_optimal(int arr[][]) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingDouble(O -> O[0]));

        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                ans.get(ans.size()-1).set(1, Math.max(arr[i][1], ans.get(ans.size()-1).get(1)));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
