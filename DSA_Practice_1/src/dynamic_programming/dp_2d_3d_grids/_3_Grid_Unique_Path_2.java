package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;

public class _3_Grid_Unique_Path_2 {

    // Recursion - 
    public static int countWays_recursion(int grid[][], int n, int m) {
        return countWays_recursion_util(grid, n, m, 0, 0);
    }

    public static int countWays_recursion_util(int grid[][], int n, int m, int i, int j) {
        if (i >= n || j >= m || grid[i][j] == 1) return 0;
        if (i == n-1 && j == m-1) return 1;

        int right = countWays_recursion_util(grid, n, m, i, j+1);
        int down = countWays_recursion_util(grid, n, m, i+1, j);

        return right+down;
    }


    // Memoization - O(N*M), O(N*M)
    public static int countWays_memoization(int grid[][], int n, int m) {
        int dp[][] = new int[n][m];

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }

        return countWays_memoization_util(grid, n, m, 0, 0, dp);
    }

    public static int countWays_memoization_util(int grid[][], int n, int m, int i, int j, int dp[][]) {
        if (i >= n || j >= m || grid[i][j] == 1) return 0;
        if (i == n-1 && j == m-1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int right = countWays_recursion_util(grid, n, m, i, j+1);
        int down = countWays_recursion_util(grid, n, m, i+1, j);

        return dp[i][j] = right+down;
    }


    // Tabulation - O(N*M), O(N*M)
    public static int countWays_tabulation(int grid[][], int n, int m) {
        int dp[][] = new int[n][m];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {

                if (i < n && j < m && grid[i][j] == 1) {
                    continue;
                }

                if (i == n-1 && j == m-1 && grid[n-1][m-1] != 1) {
                    dp[n-1][m-1] = 1;
                    continue;
                }

                // right
                int right = 0;
                if (j+1 < m) {
                    right = dp[i][j+1];
                }

                // down
                int down = 0;
                if (i+1 < n) {
                    down = dp[i+1][j];
                }

                dp[i][j] = right+down;
            }
        }

        return dp[0][0];

    }


    // Space Optimization - O(N*M), O(M)
    public static int countWays_spaceOptimization(int grid[][], int n, int m) {
        int next[] = new int[m];

        for (int i = n-1; i >= 0; i--) {
            int curr[] = new int[m];
            for (int j = m-1; j >= 0; j--) {
                if (i >= n || j >= m || grid[i][j] == 1) {
                    continue;
                }

                if (i == n-1 && j == m-1) {
                    curr[j] = 1;
                    continue;
                }

                // right
                int right = 0;
                if (j+1 < m) {
                    right = curr[j+1];
                }

                int down = 0;
                if (i+1 < n) {
                    down = next[j];
                }

                curr[j] = right+down;
                
            }

            next = curr;
        }

        return next[0];
    }
    public static void main(String[] args) {
        
    }
}
