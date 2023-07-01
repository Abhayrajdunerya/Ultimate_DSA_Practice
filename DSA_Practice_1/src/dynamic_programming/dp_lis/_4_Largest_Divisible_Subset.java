package dynamic_programming.dp_lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_Largest_Divisible_Subset {

    public List<Integer> LargestSubset(int N, int[] arr) {
        // Code here
        
        Arrays.sort(arr);
        
        List<Integer> ans = new ArrayList<>();
        int dp[] = new int[N];
        int hash[] = new int[N];
        
        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);
        
        for (int i = 0; i < N; i++) {
            hash[i] = i;
            for (int prev = 0; prev <= i-1; prev++) {
                if (arr[i]%arr[prev]==0 && dp[i] < 1+dp[prev]) {
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
        }
        
        int max = -1;
        int lastIdx = -1;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                lastIdx = i;
            }
        }
        
        ans.add(arr[lastIdx]);
        while (hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            ans.add(arr[lastIdx]);
        }
        
        reverse(ans);
        
        return ans;
    }
    
    public static void reverse(List<Integer> arr) {
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
