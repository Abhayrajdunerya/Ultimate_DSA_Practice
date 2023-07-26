package binary_search.hard_search_space;

import java.util.Arrays;

public class _8_Agressive_Cows {

    public static boolean canPlace(int arr[], int k, int dist) {
        int cntCows = 1;
        int prevPlacedCow = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]-prevPlacedCow >= dist) {
                cntCows++;
                prevPlacedCow = arr[i];
            } 

            if (cntCows >= k) return true;
        }

        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int low = 1;
        int high = stalls[n-1]-stalls[0];
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (canPlace(stalls, k, mid)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return high;
    }
    public static void main(String[] args) {
        
    }
}
