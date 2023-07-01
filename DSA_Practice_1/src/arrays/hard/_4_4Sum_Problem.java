package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _4_4Sum_Problem {

    // Brute - O(n^4), O(n)
    public static List<List<Integer>> _4_sum_brute(int arr[], int K) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                for (int k = j+1; k < n-1; k++) {
                    for (int l = k+1; l < n; l++) {
                        if (arr[i]+arr[j]+arr[k]+arr[l] == K) {
                            List<Integer> ls = new ArrayList<>();
                            ls.add(arr[i]);
                            ls.add(arr[j]);
                            ls.add(arr[k]);
                            ls.add(arr[l]);
                            Collections.sort(ls);

                            if (!set.contains(ls)) {
                                ans.add(ls);
                                set.add(ls);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    // Better - O(n^3), O(2*no. of quadruplets)+O(n)
    public static List<List<Integer>> _4_sum_better(int arr[], int K) {
        int n = arr.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                HashSet<Long> set2 = new HashSet<>();
                for (int k = j+1; k < n; k++) {
                    long sum = arr[i]+arr[j]+arr[k];
                    long fourth = K-sum;
                    if (set2.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int) fourth);

                        temp.sort(Integer::compareTo);
                        set.add(temp);
                    }
                    set2.add((long) arr[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    // Optimal - O(n^3)
    public static List<List<Integer>> _4_sum_optimal(int arr[], int K) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if (j > i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while (k < l) {
                    long sum = arr[i]+arr[j]+arr[k]+arr[l];
                    if (sum == K) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);

                        ans.add(temp);

                        k++;
                        l--;

                        while (k < l && arr[k] == arr[k-1]) k++;
                        while (k < l && arr[l] == arr[l+1]) l--;
                    } else if (sum < K) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        
    }
}
