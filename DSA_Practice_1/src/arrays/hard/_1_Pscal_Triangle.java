package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class _1_Pscal_Triangle {

    public static long nCr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n-i);
            res = res/(i+1);
        }

        return res;
    }

    // O(c)
    public static int pascalTriangle_ele(int r, int c) {
        return (int) nCr(r-1, c-1);
    }

    // O(n)
    public static void pascalTriangle_row(int n) {
        long ans = 1;

        System.out.print(ans+" ");

        for (int i = 1; i < n; i++) {
            ans = ans*(n-i);
            ans = ans/i;
            System.out.print(ans+" ");
        }
        System.out.println();
    }

    // O(n^2)
    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(generateRow(i));
        }

        return ans;
    }

    public static List<Integer> generateRow(int n) {
        List<Integer> row = new ArrayList<>();
        int ans = 1;
        row.add(ans);
        for (int i = 1; i < n; i++) {
            ans = ans * (n-i);
            ans = ans / i;
            row.add(ans);
        }

        return row;
    }

    public static void main(String[] args) {
        
    }
}
