package dynamic_programming.dp_lis;

import java.util.ArrayList;

public class _3_LIS_Binary_Search {

    // Binary Search - Most Optimized - O(NLogN), O(N)
    public static int lis_binarySearch(int arr[], int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size()-1)) {
                temp.add(arr[i]);
            } else {
                int ind = ceil(temp, arr[i]);
                temp.set(ind, arr[i]);
            }
        }
        
        
        return temp.size();
    }
    
    public static int ceil(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        int si = 0;
        int ei = n-1;
        int mid;
        int ans = -1;
        while (si <= ei) {
            mid = si+(ei-si)/2;
            
            if (arr.get(mid) >=  k) {
                ans = mid;
                ei = mid-1;
            } else {
                si = mid+1;
            }
        }
        
        return ans;
    }
    
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        return lis_binarySearch(a, size);
    }
    public static void main(String[] args) {
        
    }
}
