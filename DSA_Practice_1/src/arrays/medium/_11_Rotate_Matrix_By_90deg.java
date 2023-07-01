package arrays.medium;

import arrays.util.Util;

public class _11_Rotate_Matrix_By_90deg {

    public static void reverse(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }

    public static void rotate_clockwise(int[][] matrix) {
        int n = matrix.length;
        // int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] arr : matrix) {
            reverse(arr);
        }
        
    }

    public static void rotate_anticlockwise(int[][] matrix) {
        int n = matrix.length;
        // int m = matrix[0].length;

        for (int[] arr : matrix) {
            reverse(arr);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        
        rotate_anticlockwise(matrix);
        Util.printMatrix(matrix);
    }
}
