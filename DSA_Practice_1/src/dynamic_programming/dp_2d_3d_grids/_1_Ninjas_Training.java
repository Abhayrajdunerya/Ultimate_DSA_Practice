package dynamic_programming.dp_2d_3d_grids;

import java.util.Arrays;

public class _1_Ninjas_Training {

    // Recursion -
    public static int maxPoints_recursion(int points[][], int n) {
        int last = points[0].length; // 3
        return maxPoints_recursion_util(points, n - 1, last);
    }

    public static int maxPoints_recursion_util(int points[][], int day, int last) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last)
                    max = Math.max(max, points[day][i]);
            }

            return max;
        }

        int max = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (i != last) {
                int activity = points[day][i] + maxPoints_recursion_util(points, day-1, i);
                max = Math.max(max, activity);
            }
                
        }

        return max;

    }

    // Memoization - O(N^2), O(N^2)
    public static int maxPoints_memoization(int points[][], int n) {
        int dp[][] = new int[n][points[0].length+1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int last = points[0].length;

        return maxPoints_memoization_util(points, n-1, last, dp);
        
    }

    public static int maxPoints_memoization_util(int points[][], int day, int last, int dp[][]) {
        if (dp[day][last] != -1) return dp[day][last];
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) 
                    max = Math.max(max, points[day][i]);
            }

            return dp[day][last] = max;
        }

        int max = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (i != last) {
                int activity = points[day][i]+maxPoints_memoization_util(points, day-1, i, dp);
                max = Math.max(max, activity);
            }

        }

        return dp[day][last] = max;
    }

    // Tabulation - O(N^2), O(N^2)
    public static int maxPoints_tabulation(int points[][], int n) {
        int dp[][] = new int[n][points.length];

        int max = 0;
        for (int last = 0; last < points[0].length; last++) {
            max = Math.max(max, points[0][last]);
            int num = 0;
            for (int k = 0; k < points[0].length; k++) {
                if (k != last) {
                    num = Math.max(num, points[0][k]);
                }
            }
            dp[0][last] = num;
        }

        dp[0][points[0].length] = max;


        for (int day = 1; day < n; day++) {
            for (int last = 0; last < points[0].length; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < points[0].length; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        return dp[n-1][dp[0].length-1];
    }

    // Space Optimization - O(N^2), O(N)
    public static int maxPoints_spaceOptimization(int points[][], int n) {
        int prev[] = new int[points[0].length];

        int max = 0;
        for (int last = 0; last < prev.length; last++) {
            max = Math.max(max, points[0][last]);
            int num = 0;
            for (int k = 0; k < points[0].length; k++) {
                if (k != last) {
                    num = Math.max(num, points[0][k]);
                }
            }
            dp[0][last] = num;
        }

        dp[0][points[0].length] = max;


        for (int day = 1; day < n; day++) {
            for (int last = 0; last < points[0].length; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < points[0].length; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        return dp[n-1][dp[0].length-1];
    }

    public static void main(String[] args) {

    }
}
