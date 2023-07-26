package binary_search.easy_1d;

import java.util.ArrayList;

public class _12_Find_Peak_Element {

    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n == 1) return 0;
        if (arr.get(0) > arr.get(1)) return 0;
        if (arr.get(n-1) > arr.get(n-2)) return n-1;

        int lo = 1;
        int hi = n-2;
        int mid;

        while (lo <= hi) {
            mid = lo+(hi-lo)/2;

            if (arr.get(mid) > arr.get(mid-1) && arr.get(mid) > arr.get(mid+1)) return mid;

            if (arr.get(mid) > arr.get(mid-1)) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        
    }
}
