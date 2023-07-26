package arrays.medium;

public class _15_DiagonalSum_Matrix {

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];

            if (i != n-i-1) {
                sum += matrix[i][n-i-1];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        
    }
}
