package arrays.easy;

import arrays.util.Util;

public class _5_Left_Rotate_An_Array_By_1_Place {

    public static void leftRotate(int arr[]) {
        int n = arr.length;
        int tmp = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }

        arr[n-1] = tmp;
    }

    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        leftRotate(arr);
        Util.printArr(arr);
    }
}
