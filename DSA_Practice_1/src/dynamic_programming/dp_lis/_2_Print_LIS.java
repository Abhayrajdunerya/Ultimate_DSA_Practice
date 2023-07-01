package dynamic_programming.dp_lis;

import java.util.ArrayList;
import java.util.Arrays;

public class _2_Print_LIS {

    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]){
        // Code here
        ArrayList<Integer> seq = new ArrayList<>();
        
        int dp[] = new int[N];
        int hash[] = new int[N];
        
        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);
        
        for (int i = 0; i < N; i++) {
            hash[i] = i;
            for (int prev = 0; prev <= i-1; prev++) {
                if (arr[prev] < arr[i] && dp[i] < 1+dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        
        int lastIdx = -1;
        int ans = -1;
        for (int i = 0; i < N; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIdx = i;
            }
        }
        
        seq.add(arr[lastIdx]);
        while (hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            seq.add(arr[lastIdx]);
        }
        
        reverse(seq);
        
        return seq;
    }
    
    public static void reverse (ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n/2; i++) {
            int temp = arr.get(i);
            arr.set(i, arr.get(n-i-1));
            arr.set(n-i-1, temp);
        }
    }
    public static void main(String[] args) {
        
    }
}
