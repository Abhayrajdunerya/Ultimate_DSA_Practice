package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;

public class _6_Min_Max_Falling_Path_Sum {

    // Recursion - 
    public static int maxPathSum_recursion(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        
        int ans = (int)Math.pow(-10, 9);
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, maxPathSum_recursion_util(arr, n, m, 0, j));
        }

        return ans;
    }

    public static int maxPathSum_recursion_util(int arr[][], int n, int m, int i, int j) {
        if (i >= n || j >= m || j < 0) return (int) Math.pow(-10, 9);
        if (i == n-1) return arr[i][j];

        int down = maxPathSum_recursion_util(arr, n, m, i+1, j)+arr[i][j];
        int leftDiag = maxPathSum_recursion_util(arr, n, m, i+1, j-1)+arr[i][j];
        int rightDiag = maxPathSum_recursion_util(arr, n, m, i+1, j+1)+arr[i][j];

        return Math.max(leftDiag, Math.max(down, rightDiag));

    }

    // Memoization - O(N*M), O(N*M) 
    public static int maxPathSum_memoization(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int dp[][] = new int[n][m];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans = (int) Math.pow(-10, 9);

        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, maxPathSum_memoization_util(arr, n, m, 0, j, dp));
        }

        return ans;
    }

    public static int maxPathSum_memoization_util(int arr[][], int n, int m, int i, int j, int dp[][]) {
        if (i >= n || j >= m || j < 0) return (int) Math.pow(-10, 9);
        if (i == n-1) return arr[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int down = maxPathSum_recursion_util(arr, n, m, i+1, j)+arr[i][j];
        int leftDiag = maxPathSum_recursion_util(arr, n, m, i+1, j-1)+arr[i][j];
        int rightDiag = maxPathSum_recursion_util(arr, n, m, i+1, j+1)+arr[i][j];

        return dp[i][j] = Math.max(leftDiag, Math.max(down, rightDiag));
    }

    // Tabulation - O(N*M), O(N*M)
    public static int maxPathSum_tabulation(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int dp[][] = new int[n][m];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (i == n-1) {
                    dp[i][j] = arr[i][j];
                    continue;
                }

                int down = (int) Math.pow(-10, 9);
                int leftDiag = (int) Math.pow(-10, 9);
                int rightDiag = (int) Math.pow(-10, 9);

                down = arr[i][j]+dp[i+1][j];
                if (j-1 >= 0) leftDiag = arr[i][j]+dp[i+1][j-1];
                if (j+1 < m) rightDiag = arr[i][j]+dp[i+1][j+1];

                dp[i][j] = Math.max(leftDiag, Math.max(down, rightDiag));
            }
        }

        int ans = (int)Math.pow(-10, 9);

        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, dp[0][j]);
        }

        return ans;
    }

    // Space Optimization - O(N*M), O(M)
    public static int maxPathSum_spaceOptimization(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int _10Pow9 = (int) Math.pow(-10, 9);

        int next[] = new int[m];

        Arrays.fill(next, _10Pow9);

        for (int i = n-1; i >= 0; i--) {
            int curr[] = new int[m];
            for (int j = m-1; j >= 0; j--) {
                if (i == n-1) {
                    curr[j] = arr[i][j];
                    continue;
                }

                int down = _10Pow9;
                int leftDiag = _10Pow9;
                int rightDiag = _10Pow9;

                down = arr[i][j]+next[j];
                if (j-1 >= 0) leftDiag = arr[i][j]+next[j-1];
                if (j+1 < m) rightDiag = arr[i][j]+next[j+1];

                curr[j] = Math.max(leftDiag, Math.max(down, rightDiag));
            }

            next = curr;
        }

        int ans = _10Pow9;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, next[j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
