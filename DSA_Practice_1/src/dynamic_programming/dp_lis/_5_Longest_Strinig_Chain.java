package dynamic_programming.dp_lis;

import java.util.Arrays;
import java.util.Comparator;

public class _5_Longest_Strinig_Chain {

    public static boolean compare(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m+1) return false;
        
        int first = 0;
        int second = 0;
        while (first < n) {
            if (second < m && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        
        return first == n && second == m;
    }
    
    public static int longestChain_recursion(String[] arr, int n) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev <= i-1; prev++) {
                if (compare(arr[i], arr[prev]) && dp[prev]+1 > dp[i]) {
                    dp[i] = dp[prev]+1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    public int longestChain(int N, String words[]){
     //code here
        return longestChain_recursion(words, N);
    }
    public static void main(String[] args) {
        
    }
}
