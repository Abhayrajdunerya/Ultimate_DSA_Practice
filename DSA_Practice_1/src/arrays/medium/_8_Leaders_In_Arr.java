package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

public class _8_Leaders_In_Arr {

    // Brute - O(N^2)
    public static ArrayList<Integer> getLeaders_brute(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> leaders = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                }
            }
            if (isLeader) {
                leaders.add(arr[i]);
            }
        }

        return leaders;

    }

    // Optimal - O(n)
    public static ArrayList<Integer> getLeaders_optimal(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr[n-1]);
        int max = arr[n-1];

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }
        
        Collections.reverse(leaders);

        return leaders;
        
    }

    public static void main(String[] args) {
        
    }
}
