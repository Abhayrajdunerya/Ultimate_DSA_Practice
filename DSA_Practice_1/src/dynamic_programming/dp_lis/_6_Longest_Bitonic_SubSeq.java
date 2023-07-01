package dynamic_programming.dp_lis;

import java.util.Arrays;

public class _6_Longest_Bitonic_SubSeq {

    public static int longestBitonicSeq(int arr[]) {
        int n = arr.length;
        
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev <= i-1; prev++) {
                if (arr[prev] < arr[i]) {
                    dp1[i] = Math.max(dp1[prev]+1, dp1[i]);
                }
            }
        }
        
        for (int i = n-1; i >= 0; i--) {
            for (int prev = n-1; prev > i; prev--) {
                if (arr[prev] < arr[i]) {
                    dp2[i] = Math.max(dp2[prev]+1, dp2[i]);
                }
            }
        }
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(dp1[i]+dp2[i]-1, max);
        }
        
        
        return max;
        
    }
    
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        return longestBitonicSeq(nums);
    }
    public static void main(String[] args) {
        
    }
}
