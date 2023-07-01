package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;
import java.util.List;

public class _5_Min_Path_Sum_In_Triangular_Grid {

    // Recursion - 
    public static int minPathSum_recursion(List<List<Integer>> triangle) {
        int n = triangle.size();

        return minPathSum_recursion_util(triangle, n, 0, 0);
    }

    public static int minPathSum_recursion_util(List<List<Integer>> triangle, int n, int i, int j) {
        if (i == n-1) return triangle.get(i).get(j);
        if (i >= n) return (int)Math.pow(10, 9);

        int data = triangle.get(i).get(j);
        int down = minPathSum_recursion_util(triangle, n, i+1, j)+data;
        int diag = minPathSum_recursion_util(triangle, n, i+1, j+1)+data;

        return Math.min(down, diag);
    }

    // Memoization - O(N*N), O(N*N)
    public static int minPathSum_memoization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }

        return minPathSum_memoization_util(triangle, n, 0, 0, dp);
    }

    public static int minPathSum_memoization_util(List<List<Integer>> triangle, int n, int i, int j, int dp[][]) {
        if (i == n-1) return triangle.get(i).get(j);
        if (i >= n) return (int) Math.pow(10, 9);

        if (dp[i][j] != -1) return dp[i][j];

        int data = triangle.get(i).get(j);
        int down = minPathSum_memoization_util(triangle, n, i+1, j, dp)+data;
        int diag = minPathSum_memoization_util(triangle, n, i+1, j+1, dp)+data;

        return dp[i][j] = Math.min(diag, down);
    }

    // Tabulation - O(N*N), O(N*N)
    public static int minPathSum_tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (i == n-1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }

                int down = (int) Math.pow(10, 9);
                int diag = (int) Math.pow(10, 9);

                if (i+1 < n) {
                    down = triangle.get(i).get(j) + dp[i+1][j];

                    diag = triangle.get(i).get(j) + dp[i+1][j+1];
                }

                dp[i][j] = Math.min(down, diag);
            }
        }

        return dp[0][0];
    }

    // Space Optimization - O(N*N), O(N)
    public static int minPathSum_spaceOptimization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int next[] = new int[n];
        int _10Pow9 = (int) Math.pow(10, 9);

        for (int i = n-1; i >= 0; i--) {
            int curr[] = new int[i+1];
            for (int j = i; j >= 0; j--) {
                if (i == n-1) {
                    curr[j] = triangle.get(i).get(j);
                    continue;
                }

                int down = _10Pow9;
                int diag = _10Pow9;

                if (i+1 < n) {
                    down = triangle.get(i).get(j) + next[j];

                    diag = triangle.get(i).get(j) + next[j+1];
                }

                curr[j] = Math.min(diag, down);
            }

            next = curr;
        }

        return next[0];
    }

    public static void main(String[] args) {
        
    }
}
