package arrays.easy;

import arrays.util.Util;

public class _6_Left_Rotate_An_Array_By_D_Places {

    // Brute - O(n*d)
    public static void leftRotate(int arr[], int d) {
        d = d%arr.length;
        for (int i = 0; i < d; i++) {
            _5_Left_Rotate_An_Array_By_1_Place.leftRotate(arr);
        }
    }

    // Better - O(n), O(n)
    public static void leftRotate_better(int arr[], int d) {
        int n = arr.length;
        d = d%n;
        int temp[] = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }

        for (int i = n-d; i < n; i++) {
            arr[i] = temp[i-(n-d)];
        }
        
    }

    // Optimal - O(n)
    public static void leftRotate_optimal(int arr[], int d) {
        int n = arr.length;
        d = d%n;

        Util.reverseArr(arr, 0, d-1);
        Util.reverseArr(arr, d, n-1);
        Util.reverseArr(arr);

    }

    


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};

        // leftRotate(arr, 12);
        // leftRotate_better(arr, 12);
        leftRotate_optimal(arr, 12);
        Util.printArr(arr);

    }
}
