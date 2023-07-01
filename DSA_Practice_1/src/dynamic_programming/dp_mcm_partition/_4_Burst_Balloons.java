package dynamic_programming.dp_mcm_partition;

import java.util.Arrays;

public class _4_Burst_Balloons {

    // Recursion - 
    public static int maxCoins_recursion(int arr[]) {
        int n = arr.length;
        int newArr[] = new int[n+2];
        newArr[0] = 1;
        newArr[newArr.length-1] = 1;

        for (int i = 0; i < n; i++) {
            newArr[i+1] = arr[i];
        }

        return maxCoins_recursion_util(newArr, 1, n);
    }

    public static int maxCoins_recursion_util(int arr[], int i, int j) {
        if (i > j) return 0;
        
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int currCoins = arr[i-1]*arr[k]*arr[j+1];
            int leftCoins = maxCoins_recursion_util(arr, i, k-1);
            int rightCoins = maxCoins_recursion_util(arr, k+1, j);

            int totCoins = currCoins+leftCoins+rightCoins;

            maxCoins = Math.max(maxCoins, totCoins);
        }

        return maxCoins;
    }

    // Memoization - O(N*N*N), O(N*N)+O(N)
    public static int maxCoins_memoization(int arr[]) {
        int n = arr.length;
        int newArr[] = new int[n+2];
        newArr[0] = 1;
        newArr[newArr.length-1] = 1;

        for (int i = 0; i < n; i++) {
            newArr[i+1] = arr[i];
        }

        int dp[][] = new int[n+1][n+1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return maxCoins_memoization_util(newArr, 1, n, dp);
    }

    public static int maxCoins_memoization_util(int arr[], int i, int j, int dp[][]) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int currCoins = arr[i-1]*arr[k]*arr[j+1];
            int leftCoins = maxCoins_memoization_util(arr, i, k-1, dp);
            int rightCoins = maxCoins_memoization_util(arr, k+1, j, dp);

            int totCoins = currCoins+leftCoins+rightCoins;

            maxCoins = Math.max(maxCoins, totCoins);
        }

        return dp[i][j] = maxCoins;
    }

    // Tabulation - O(N*N*N), O(N*N)
    public static int mexCoins_tabulation(int nums[]) {
        int n = nums.length;

        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }

        int dp[][] = new int[n+2][n+2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;

                int maxCoins = 0;
                for (int k = i; k <= j; k++) {
                    int currCoins = arr[i-1]*arr[k]*arr[j+1];
                    int leftCoins = dp[i][k-1];
                    int rightCoins = dp[k+1][j];

                    int totCoins = currCoins+leftCoins+rightCoins;

                    maxCoins = Math.max(maxCoins, totCoins);
                    dp[i][j] = maxCoins;
                }

            }
        }

        return dp[1][n];
    }
    public static void main(String[] args) {
        
    }
}
