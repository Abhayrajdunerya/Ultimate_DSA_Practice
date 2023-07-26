package recursion.subsequence_pattern;

public class _6_Check_If_There_Exist_A_SubSeq_With_Sum_K {

    public static boolean subSetSumK_recursion(int arr[], int n, int k) {
        if (k == 0) return true;
        if (n == 0) return false;;

        boolean notTake = subSetSumK_recursion(arr, n-1, k);
        boolean take = false;
        if (arr[n-1] <= k) {
            take = subSetSumK_recursion(arr, n-1, k-arr[n-1]);
        }

        return take || notTake;
    }

    public static boolean subSetSumK_tabulation(int arr[], int n, int k) {
        boolean dp[][] = new boolean[n+1][k+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if (arr[i-1] <= j) {
                    take = dp[i-1][j-arr[i-1]];
                }
                dp[i][j] = take || notTake;
            }
        }

        return dp[n][k];
    }

    public static boolean subSetSumK_spaceOptimization(int arr[], int n, int k) {
        boolean prev[] = new boolean[k+1];

        prev[0] = true;

        for (int i = 1; i < n+1; i++) {
            boolean curr[] = new boolean[k+1];
            curr[0] = true;

            for (int j = 1; j < k+1; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (arr[i-1] <= j) {
                    take = prev[j-arr[i-1]];
                }
                curr[j] = take || notTake;
            }

            prev = curr;
        }

        return prev[k];
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // return subSetSumK_recursion(a, n, k);
        // return subSetSumK_tabulation(a, n, k);
        return subSetSumK_spaceOptimization(a, n, k);
    }
    public static void main(String[] args) {
        
    }
}
