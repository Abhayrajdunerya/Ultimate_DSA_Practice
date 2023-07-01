package arrays.util;

public class Util {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void reverseArr(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            swapArr(arr, i, n-i-1);
        }
    }

    public static void reverseArr(int arr[], int s, int e) {
        while (s < e) {
            swapArr(arr, s, e);
            s++;
            e--;
        }
    }

    public static void swapArr(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
    }
}
