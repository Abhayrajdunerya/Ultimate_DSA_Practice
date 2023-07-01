package arrays.easy;

import java.util.HashMap;

public class _12_Find_Num_Appear_1s_Ot_2s {

    // Brute - O(n^2)
    public static int findNum_brute(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) count++;
            }

            if (count == 1) return arr[i];
        }

        return -1;
    }

    // Better - O(2n), O(n)
    public static int findNum_better(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }

    // Optimal - O(n)
    public static int findNum_optimal(int arr[]) {
        int n = arr.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
        }

        return xor;
    }
    public static void main(String[] args) {
        
    }
}
