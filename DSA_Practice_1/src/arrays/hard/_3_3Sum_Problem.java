package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _3_3Sum_Problem {

    // O(n^3), O(N)
    public static List<List<Integer>> _3sum_brute(int arr[], int K) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (arr[i]+arr[j]+arr[k] == K) {
                        List<Integer> ls = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                        Collections.sort(ls);
                        if (!set.contains(ls)) {
                            ans.add(ls);
                            set.add(ls);
                        }
                    }
                }
            }
        }

        return ans;
    }

    // Better - O(n^2), O(n)
    public static List<List<Integer>> _3sum_better(int arr[], int K) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> set2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int z = K-(arr[i]+arr[j]);
                if (set.contains(z)) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(arr[i]);
                    ls.add(arr[j]);
                    ls.add(z);
                    Collections.sort(ls);
                    if (!set2.contains(ls)) {
                        ans.add(ls);
                        set2.add(ls);
                    }
                }
            }
        }

        return ans;
    }

    // Optimal - O(n^2)
    public static List<List<Integer>> _3sum_optimal(int arr[], int K) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n-2; i++) {
            if (i == 0 || (i > 0 && arr[i] != arr[i-1])) {
                int left = i+1, right = n-1;
                int sum = K-(arr[i]);
                while (left < right) {
                    if (arr[left] + arr[right] == sum) {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(arr[i]);
                        ls.add(arr[left]);
                        ls.add(arr[right]);

                        ans.add(ls);

                        while (left < right && arr[left] == arr[left+1]) left++;
                        while (left < right && arr[right] == arr[right-1]) right--;

                        left++;
                        right--;
                    } else if (arr[right] + arr[left] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        
    }
}
