package arrays.hard;

import java.util.Arrays;

public class _7_Merge_Two_Sorted_Arrays_Without_Extra_Space {

    // Brute - O(n+m), O(n+m)
    public static void merge_brute(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int ans[] = new int[n+m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                ans[k++] = arr1[i++];
            } else {
                ans[k++] = arr2[j++];
            }
        }

        while (i < n) ans[k++] = arr1[i++];
        while (j < m) ans[k++] = arr2[j++];

        for (i = 0; i < n; i++) {
            arr1[i] = ans[i];
        }

        for (i = 0; i < m; i++) {
            arr2[i] = ans[i+n];
        }
    }

    // Optimal 1 - O(min(n,m)) + O(n*logn) + O(m*logm)
    public static void merge_optimal_1(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int left = n-1;
        int right = 0;

        while (left >= 0 && right < m) {
            if (arr2[right] < arr1[left]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left--; right++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Optimal 2 - O((n+m)log(n+m))
    public static void merge_optimal_2(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int len = n+m;
        int gap = (len/2) + (len)%2;

        while (gap > 0) {
            int left = 0;
            int right = left+gap;

            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right-n);
                } else if (left >= n) {
                    swapIfGreater(arr2, arr2, left-n, right-n);
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            if (gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }

    public static void swapIfGreater(int arr1[], int arr2[], int left, int right) {
        if (arr1[left] > arr2[right]) {

            int temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }

    public static void main(String[] args) {
        
    }
}
