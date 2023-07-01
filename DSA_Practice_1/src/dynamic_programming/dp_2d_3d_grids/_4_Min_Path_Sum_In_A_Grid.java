package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;

public class _4_Min_Path_Sum_In_A_Grid {

    // Recursion - 
    public static int minPathSum_recursion(int grid[][], int n, int m) {
        return minPathSum_recursion_util(grid, n, m, 0, 0);
    }

    public static int minPathSum_recursion_util(int grid[][], int n, int m, int i, int j) {
        if (i == n-1 && j == m-1) return grid[i][j];
        if (i >= n || j >= m) return (int) Math.pow(10, 9);

        int right = minPathSum_recursion_util(grid, n, m, i, j+1)+grid[i][j];
        int down = minPathSum_recursion_util(grid, n, m, i+1, j)+grid[i][j];

        return Math.min(right, down);
    }

    // Memoization - O(N*M), O(N*M)
    public static int minPathSum_memoization(int grid[][], int n, int m) {
        int dp[][] = new int[n][m];

        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }

        return minPathSum_memoization_util(grid, n, m, 0, 0, dp);
    }

    public static int minPathSum_memoization_util(int grid[][], int n, int m, int i, int j, int dp[][]) {
        if (i == n-1 && j == m-1) return grid[i][j];
        if (i >= n || j >= m) return (int) Math.pow(10, 9);

        if (dp[i][j] != -1) return dp[i][j];

        int right = minPathSum_recursion_util(grid, n, m, i, j+1)+grid[i][j];
        int down = minPathSum_recursion_util(grid, n, m, i+1, j)+grid[i][j];

        return dp[i][j] = Math.min(right, down);
    }


    // Tabulation - O(N*M), O(N*M)
    public static int minPathSum_tabulation(int grid[][], int n, int m) {
        int dp[][] = new int[n][m];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (i == n-1 && j == m-1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int right = (int) Math.pow(10, 9);
                int down = (int) Math.pow(10, 9);

                if (j+1 < m) {
                    right = dp[i][j+1] + grid[i][j];
                }

                if (i+1 < n) {
                    down = dp[i+1][j] + grid[i][j];
                }

                dp[i][j] = Math.min(right, down);
                
            }
        }

        return dp[0][0];

    }


    // Space Optimization - O(N*M), O(M)
    public static int minPathSum_spaceOptimization(int grid[][], int n, int m) {
        int next[] = new int[m];
        int _10Pow9 = (int)Math.pow(10, 9);
        Arrays.fill(next, _10Pow9);

        for (int i = n-1; i >= 0; i--) {
            int curr[] = new int[m];
            for (int j = m-1; j >= 0; j--) {
                if (i == n-1 && j == m-1) {
                    curr[j] = grid[i][j];
                    continue;
                }

                int right = (int) Math.pow(10, 9);
                int down = (int) Math.pow(10, 9);

                if (j+1 < m) {
                    right = curr[j+1] + grid[i][j];
                }

                if (i+1 < n) {
                    down = next[j] + grid[i][j];
                }

                curr[j] = Math.min(right, down);

            }

            next = curr;
        }

        return next[0];
    }


    public static void main(String[] args) {
        
    }
}
