package arrays.medium;

import java.util.HashMap;

public class _3_Majority_Ele_n$2_Times {

    // Brute - O(n^2)
    public static int majorityEle_brute(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count > n/2) return arr[i];
        }
        return -1;
    }

    // Better - O(n), O(n)
    public static int majorityEle_better(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer x : map.keySet()) {
            if (map.get(x) > n/2) {
                return x;
            }
        }

        return -1;
    }

    // Optimal - O(2n)
    public static int majorityEle_optimal_moors_voting_algo(int arr[]) {
        int n = arr.length;
        int ele = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                ele = arr[i];
                cnt = 1;
            } else if (ele == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele) {
                cnt1++;
            }
            if (cnt1 > n/2) return ele;
        }

        return -1;
    }

    public static void main(String[] args) {
        
    }
}
