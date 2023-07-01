package arrays.easy;

import java.util.ArrayList;

import arrays.util.Util;

public class _7_Move_Zeros_To_End {

    // Brute - O(2n), O(n)
    public static void moveZerosEnd_Brute(int arr[]) {
        int n = arr.length;

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        for (int i = temp.size(); i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void moveZerosEnd_Optimal (int arr[]) {
        int j = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return;
        }

        for (int i = j+1; i < n; i++) {
            if (arr[i] != 0) {
                Util.swapArr(arr, i, j);
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,0,2,3,2,0,0,4,5,1};
        // moveZerosEnd_Brute(arr);
        moveZerosEnd_Optimal(arr);

        Util.printArr(arr);
    }
}
