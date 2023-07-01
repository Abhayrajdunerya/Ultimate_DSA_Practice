package arrays.medium;

import java.util.HashMap;

public class _13_Find_No_Of_SubArr_With_Sum_K {

    // Brute - O(N^2)
    public static int subArraySumK_brute(int arr[], int K) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == K) count++;
            }
        }

        return count;
    }

    // Optimal - O(n), O(n)
    public static int subArraySumK_optimal(int arr[], int K) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int rem = preSum-K;
            cnt += map.getOrDefault(rem, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        int K = 3;
        System.out.println(subArraySumK_brute(arr, K));
        System.out.println(subArraySumK_optimal(arr, K));
    }
}
