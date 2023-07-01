package arrays.easy;

import java.util.ArrayList;
import java.util.TreeSet;

public class _9_Find_Union_Of_Two_Sorted_Arrays {

    // Brute - O(n+m), O(n+m)
    public static ArrayList<Integer> getAns_Brute(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        
        for (int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        
        for (int x: set) {
            ans.add(x);
        }
        
        return ans;
        
    }
    
    // Optimal - O(n+m)
    public static ArrayList<Integer> getAns_Optimal(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (ans.size() == 0 || ans.get(ans.size()-1) != arr1[i]) {
                    ans.add(arr1[i]);
                }
                i++;
            } else {
                if (ans.size() == 0 || ans.get(ans.size()-1) != arr2[j]) {
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        
        while (i < n) {
            if (ans.size() == 0 || ans.get(ans.size()-1) != arr1[i]) {
                ans.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (ans.size() == 0 || ans.get(ans.size()-1) != arr2[j]) {
                ans.add(arr2[j]);
            }
            j++;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
