package arrays.easy;

import java.util.Arrays;

public class _2_Second_Largest_Ele_In_An_Array {

    public static int largest(int arr[]) {
        int n = arr.length;

        int lg = arr[0];

        for (int i = 0; i < n; i++) {
            lg = Math.max(lg, arr[i]);
        }

        return lg;
    }

    // Brute - O(2n)
    public static int secondLargest(int arr[]) {
        int n = arr.length;

        // getLargest
        int largest = largest(arr);

        int slg = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < largest) {
                slg = Math.max(slg, arr[i]);
            }
        }

        return slg;

    }

    // better - (nlogn)
    public static int secondLargest_better(int arr[]) {
        int n = arr.length;

        Arrays.sort(arr);

        int slg = -1;

        int i = n-2;

        while (i >= 0) {
            if (arr[i] == arr[i+1]) {
                i--;
            } else {
                slg = arr[i];
                break;
            }
        }

        return slg;
    }

    // optimal - O(n)
    public static int secondLargest_optimal(int arr[]) {
        int n = arr.length;

        int lg = -1;
        int slg = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > lg) {
                slg = lg;
                lg = arr[i];
            } else if (slg < arr[i] && arr[i] < lg) {
                slg = arr[i];
            }
        }

        return slg;
    }

    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};

        System.out.println(secondLargest(arr));
        System.out.println(secondLargest_better(arr));
        System.out.println(secondLargest_optimal(arr));
    }
}
