package arrays.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import arrays.util.Util;

public class _1_2Sum_Problem {

    // Brute - O(n^2)
    public static int[] sum_2_brute(int arr[], int target) {
        int n = arr.length;
        int ans[] = new int[2];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;

                    return ans;
                }
            }
        }

        return ans;
    }

    // Better - O(n), O(n)
    public static int[] sum_2_better(int arr[], int K) {
        int ans[] = new int[2];
        Arrays.fill(ans, -1);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = K - arr[i];
            if (map.containsKey(rem)) {
                ans[0] = i;
                ans[1] = map.get(rem);
                break;
            }

            map.put(arr[i], i);
        }

        return ans;
    }

    // Optimal - O(n)
    public static int[] sum_2_optimal(int arr[], int K) {
        int temp[][] = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = i;
            temp[i][1] = arr[i];
        }

        int ans[] = new int[2];
        Arrays.fill(ans, -1);
        int left = 0;
        int right = arr.length-1;

        Arrays.sort(temp, Comparator.comparingDouble(o -> o[1]));

        while (left < right) {
            int sum = temp[left][1]+temp[right][1];
            if (sum == K) {
                ans[0] = temp[left][0];
                ans[1] = temp[right][0];
                return ans;
            } else if (sum < K) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
        
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int target = 6;

        Util.printArr(sum_2_optimal(arr, target));
    }
}
