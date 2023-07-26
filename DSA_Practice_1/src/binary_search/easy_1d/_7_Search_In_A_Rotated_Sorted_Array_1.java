package binary_search.easy_1d;

import java.util.ArrayList;

public class _7_Search_In_A_Rotated_Sorted_Array_1 {

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int lo = 0;
        int hi = arr.size()-1;
        int mid;

        while (lo <= hi) {
            mid = lo+(hi-lo)/2;

            if (arr.get(mid) == k) return mid;

            if (arr.get(lo) <= arr.get(mid)) {
                if (k >= arr.get(lo) && k <= arr.get(mid)) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else {
                if (k >= arr.get(mid) && k <= arr.get(hi)) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        
    }
}
