package arrays.hard;

import java.util.HashMap;

public class _5_Count_No_Of_SubArr_With_XOR_K {

    // Brute - O(n^3)
    public static int countSubarr_brute(int arr[], int K) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor^arr[k];
                }
                if (xor == K) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // Better - O(n^2)
    public static int countSubarr_better(int arr[], int K) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor^arr[j];
                if (xor == K) cnt++;
            }
        }

        return cnt;
    }

    // Optimal - O(n), O(n)
    public static int countSubarr_optimal(int arr[], int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int cnt = 0;
        int xr = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            xr = xr^arr[i];
            int x = xr^K;
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        
    }
}
