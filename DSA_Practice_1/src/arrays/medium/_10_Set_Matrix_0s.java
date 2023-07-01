package arrays.medium;

public class _10_Set_Matrix_0s {

    public static void makeRow(int matrix[][], int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[row][j] != 0)
                matrix[row][j] = -1;
        }
    }

    public static void makeCol(int matrix[][], int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = -1;
        }
    }

    // Brute - O((n*m)+(n+m))+O(n*m)
    public static void setMatrix0_brute(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    makeRow(matrix, i);
                    makeCol(matrix, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Better - O(2*n*m), O(n)+O(m)
    public static void setMatrix0_better(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal - O(2*n*m)
    public static void setMatrix0_optimal(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
