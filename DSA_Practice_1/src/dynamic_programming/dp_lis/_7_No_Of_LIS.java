package dynamic_programming.dp_lis;

import java.util.Arrays;

public class _7_No_Of_LIS {

    public static int countLIS(int arr[], int n) {
        int dp[] = new int[n];
        int cnt[] = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev <= i-1; prev++) {
                if (arr[prev] < arr[i] && dp[prev]+1 > dp[i]) {
                    dp[i] = 1+dp[prev];
                    cnt[i] = cnt[prev];
                } else if (arr[prev] < arr[i] && dp[prev]+1 == dp[i]) {
                    cnt[i] = cnt[i]+cnt[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                count += cnt[i];
            }
        }
        
        return count;
        
    }
    
    public int NumberofLIS(int N, int arr[]){
        // Code here
        return countLIS(arr, N);
    }
    
    public static void main(String[] args) {
        
    }
}
