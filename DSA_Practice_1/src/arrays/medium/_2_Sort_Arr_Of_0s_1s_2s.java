package arrays.medium;

import java.util.Arrays;

import arrays.util.Util;

public class _2_Sort_Arr_Of_0s_1s_2s {

    // Brute - O(nlogn)
    public static void sort012_brute(int arr[]) {
        Arrays.sort(arr);
    }

    // Better - O(2n), O(n)
    public static void sort012_better(int arr[]) {
        int count[] = new int[3];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[k++] = i;
                count[i]--;
            }
        }
    }

    // Optimal - O(n)
    public static void sort012_optimal_dutch_national_flag_algo(int arr[]) {
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                Util.swapArr(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                Util.swapArr(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
