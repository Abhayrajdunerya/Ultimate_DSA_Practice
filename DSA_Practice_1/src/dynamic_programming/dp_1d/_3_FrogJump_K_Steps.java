package dynamic_programming.dp_1d;

import java.util.Arrays;

public class _3_FrogJump_K_Steps {

    // Recursion
    public static int minEnergy_recursion(int arr[], int idx, int k) {
        if (idx == 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if(idx-j >= 0) {
                if (idx-j >= 0) {
                    int jump = Math.abs(arr[idx]-arr[idx-j])+minEnergy_recursion(arr, idx-j, k);
                    minEnergy = Math.min(minEnergy, jump);
                }
            }
        }

        return minEnergy;
    }

    // Memoization - O(N*K), O(N)
    public static int minEnergy_memoization(int arr[], int n, int k) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return minEnergy_memoization_util(arr, dp, n-1, k);
    }

    public static int minEnergy_memoization_util(int arr[], int dp[], int idx, int k) {
        if (idx == 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx-i >= 0) {
                int jump = Math.abs(arr[idx]-arr[idx-i])+minEnergy_memoization_util(arr, dp, idx-i, k);
                minEnergy = Math.min(minEnergy, jump);
            }
        }

        return minEnergy;
    }

    // Tabulation - O(N*K), O(N)
    public static int minEnergy_Tabulation(int arr[], int n, int k) {
        int dp[] = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i-j >= 0) {
                    int jump = Math.abs(arr[i]-arr[i-j])+dp[i-j];
                    mmSteps = Math.min(mmSteps, jump);
                }
            }
            dp[i] = mmSteps;
        }

        return dp[n-1];
    }


    public static void main(String[] args) {
        
    }
}
