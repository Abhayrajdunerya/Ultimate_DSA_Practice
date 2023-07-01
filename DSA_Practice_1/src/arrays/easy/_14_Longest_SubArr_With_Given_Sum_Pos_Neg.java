package arrays.easy;

import java.util.HashMap;

public class _14_Longest_SubArr_With_Given_Sum_Pos_Neg {

    // Brute - O(n^3)
    public static int longestSubArr_brute(int arr[], int K) {
        int n = arr.length;

        int maxLen = 0;
        int currLen = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == K) {
                    currLen = j-i+1;
                    maxLen = Math.max(maxLen, currLen);
                }
            }
        }

        return maxLen;
    }

    // Better 2 - O(n^2)
    public static int longestSubArr_better(int arr[], int K) {
        int n = arr.length;

        int maxLen = 0;
        int currLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == K) {
                    currLen = j-i+1;
                    maxLen = Math.max(maxLen, currLen);
                }
            }
        }

        return maxLen;
    }

    // Optimal - O(n), O(n)
    public static int longestSubArr_optimal (int arr[], int K) {
        int maxLen = 0;
        int n = arr.length;
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();    // sum, index

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == K) maxLen = Math.max(maxLen, i+1);
            long rem = sum-K;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }

        return maxLen;

    }
    public static void main(String[] args) {
        
    }
}
