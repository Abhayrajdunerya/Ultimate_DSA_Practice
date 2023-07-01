package arrays.medium;

public class _12_Spiral_Matrix {

    public static void spiralMatrix(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int sr = 0, sc = 0;
	    int er = n-1, ec = m-1;
	    
	    while (sr <= er && sc <= ec) {
	       // Top
	       for (int j = sc; j <= ec; j++) {
	           System.out.print(arr[sr][j] + " ");
	       }
	       
	       // Right
           for (int i = sr+1; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
           }
	       
	       // Bottom
           for (int j = ec-1; j >= sc; j--) {
                if (sr == er) break;
                System.out.print(arr[er][j] + " ");
           }
	       
	       // Left
           for (int i = er-1; i >= sr+1; i--) {
                if (sc == ec) break;
                System.out.print(arr[i][sc]+" ");
           }

           sr++;
           sc++;
           er--;
           ec--;
	    }
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        spiralMatrix(matrix);
    }
}
