package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;

public class _2_Grid_Unique_Path {

    // Recursion - 
    public static int getPaths_recursion(int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        int up = getPaths_recursion(i-1, j);
        int left = getPaths_recursion(i, j-1);

        return up+left;
    }


    // Memoization - O(N^2), O(N^2)
    public static int getPaths_memoization(int n, int m) {
        int dp[][] = new int[n][m];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getPaths_memoization_util(n-1, m-1, dp);

    }

    public static int getPaths_memoization_util(int i, int j, int dp[][]) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = getPaths_memoization_util(i-1, j, dp);
        int left = getPaths_memoization_util(i, j-1, dp);

        return dp[i][j] = up+left;
    }
    

    // Tabulation - O(N^2), O(N^2)
    public static int getPaths_tabulation(int n, int m) {
        int dp[][] = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                if (i > 0) {
                    up = dp[i-1][j];
                }

                int left = 0;
                if (j > 0) {
                    left = dp[i][j-1];
                }

                dp[i][j] = up+left;
            }
        }

        return dp[n-1][m-1];

    }


    // Space Optimization - O(N^2)
    public static int getPaths_spaceOptimization(int n, int m) {
        int prev[] = new int[m];

        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                if (i > 0) {
                    up = prev[j];
                }

                int left = 0;
                if (j > 0) {
                    left = temp[j-1];
                }

                temp[j] = up+left;
                
            }

            prev = temp;
        }

        return prev[m-1];
    }


    public static void main(String[] args) {
        
    }
}
