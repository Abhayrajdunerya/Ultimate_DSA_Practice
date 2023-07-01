package arrays.easy;

import java.util.ArrayList;

public class _10_Find_Intersection_Of_Two_Sorted_Arrays {

    // Brute - O(n*m), O(n)
    public static ArrayList<Integer> intersection_brute (int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int vis[] = new int[m];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && vis[j] == 0) {
                    ans.add(arr1[i]);
                    vis[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i]) break;
            }
        }

        return ans;

    }

    // Op - O(n1+n2)
    public static ArrayList<Integer> intersection_optimal (int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (ans.size() == 0 || ans.get(ans.size()-1) != arr1[i]) {
                    ans.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        
    }
}
