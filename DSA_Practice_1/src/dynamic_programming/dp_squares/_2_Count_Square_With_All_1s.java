package dynamic_programming.dp_squares;

public class _2_Count_Square_With_All_1s {

    public int countSquares(int N, int M, int mat[][]) {
        // Code here
        int dp[][] = new int[N][M];
        
        for (int i = 0; i < N; i++) dp[i][0] = mat[i][0];
        for (int j = 0; j < M; j++) dp[0][j] = mat[0][j];
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diag = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(up, Math.min(left, diag));
                }
            }
        }
        
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt += dp[i][j];
            }
        }
        
        return cnt;
        
    }
    public static void main(String[] args) {
        
    }
}
