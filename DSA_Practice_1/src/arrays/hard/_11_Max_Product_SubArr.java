package arrays.hard;


public class _11_Max_Product_SubArr {

    // Brute - O(N^3)
    public static int maxProductSubArr_brute(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= arr[k];
                }
                max = Math.max(max, prod);
            }
        }

        return max;
    }

    // Better - O(N^2)
    public static int maxProductSubArr_better(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= arr[j];
                max = Math.max(max, prod);
            }
        }

        return max;
    }

    // Optimal - O(N)
    public static int maxProductSubArr_optimal(int arr[]) {
        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;

            pre = pre*arr[i];
            suff = suff*arr[n-i-1];

            ans = Math.max(ans, Math.max(pre, suff));
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
