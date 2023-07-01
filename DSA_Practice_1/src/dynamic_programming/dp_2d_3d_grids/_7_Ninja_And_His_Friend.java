package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;

public class _7_Ninja_And_His_Friend {

    // Recursion - 
    public static int maxChocolates_recursion(int grid[][], int n, int m) {
        return maxChocolates_recursion_util(grid, n, m, 0, 0, m-1);
    }

    public static int maxChocolates_recursion_util(int grid[][], int n, int m, int i, int j1, int j2) {
        if (i >= n || j1 >= m || j1 < 0 || j2 >= m || j2 < 0) return (int) Math.pow(-10, 9);
        if (i == n-1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans = Integer.MIN_VALUE;
                if (j1 == j2) {
                    ans = Math.max(ans, maxChocolates_recursion_util(grid, n, m, i+1, j1+di, j2+dj))+grid[i][j1];
                } else {
                    ans = Math.max(ans, maxChocolates_recursion_util(grid, n, m, i+1, j1+di, j2+dj))+grid[i][j1]+grid[i][j2];
                }

                max = Math.max(ans, max);
            }
        }

        return max;
    }

    // Memoization - O(N*M*M)*9, O(N*M*M)
    public static int maxChocolates_memoization(int grid[][], int n, int m) {
        int dp[][][] = new int[n][m][m];

        for (int matrix[][] : dp) {
            for (int row[] : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return maxChocolates_memoization_util(grid, n, m, 0, 0, m-1, dp);

    }

    public static int maxChocolates_memoization_util(int grid[][], int n, int m, int i, int j1, int j2, int dp[][][]) {
        if (i >= n || j1 >= m || j1 < 0 || j2 >= m || j2 < 0) return (int) Math.pow(-10, 9);
        if (i == n-1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans = Integer.MIN_VALUE;
                if (j1 == j2) {
                    ans = Math.max(ans, maxChocolates_recursion_util(grid, n, m, i+1, j1+di, j2+dj))+grid[i][j1];
                } else {
                    ans = Math.max(ans, maxChocolates_recursion_util(grid, n, m, i+1, j1+di, j2+dj))+grid[i][j1]+grid[i][j2];
                }

                max = Math.max(ans, max);
            }
        }

        return dp[i][j1][j2] = max;
    }

    // Tabulation - O(N*M*M)*9, O(N*M*M)
    public static int maxChocolates_tabulation(int grid[][], int n, int m) {
        int dp[][][] = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1]+grid[n-1][j2];
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans = Integer.MIN_VALUE;
                            
                            if (j1 == j2) ans = grid[i][j1];
                            else ans = grid[i][j1]+grid[i][j2];

                            if (j1+di < 0 || j1+di >= m || j2+dj < 0 || j2+dj >= m) {
                                ans += (int) Math.pow(-10, 9);
                            } else {
                                ans += dp[i+1][j1+di][j2+dj];
                            }

                            max = Math.max(max, ans);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m-1];
    }

    // Space Optimization - O(N*M*M), O(M*M)
    public static int maxChocolates_spaceOptimization(int grid[][], int n, int m) {
        int next[][] = new int[m][m];
        int curr[][] = new int[m][m];
        
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    next[j1][j2] = grid[n-1][j1];
                } else {
                    next[j1][j2] = grid[n-1][j1]+grid[n-1][j2];
                }
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans = Integer.MIN_VALUE;

                            if (j1 == j2) ans = grid[i][j1];
                            else ans = grid[i][j1]+grid[i][j2];

                            if (j1+di < 0 || j1+di >= m || j2+dj < 0 || j2+dj >= m) {
                                ans += Math.pow(-10, 9);
                            } else {
                                ans += next[j1+di][j2+dj];
                            }

                            max = Math.max(max, ans);
                        }
                    }

                    curr[j1][j2] = max;
                }
            }

            for (int a = 0; a < m; a++) {
                next[a] = (int[]) (curr[a].clone());
            }
        }

        return next[0][m-1];
    }

    public static void main(String[] args) {
        
    }
}
