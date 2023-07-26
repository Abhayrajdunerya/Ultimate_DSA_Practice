package binary_search.easy_1d;

import java.util.ArrayList;

public class _11_Find_Single_Ele_In_Sorted_Arr {

    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size();

        if (n == 1) return arr.get(0);
        if (!arr.get(0).equals(arr.get(1))) return arr.get(0);
        if (!arr.get(n-1).equals(arr.get(n-2))) return arr.get(n-1);

        int lo = 1;
        int hi = n-2;
        int mid;

        while (lo <= hi) {
            mid = lo+(hi-lo)/2;

            if (!arr.get(mid).equals(arr.get(mid-1)) && !arr.get(mid).equals(arr.get(mid+1))) return arr.get(mid);
            if ((mid%2 == 1 && arr.get(mid).equals(arr.get(mid-1))) || (mid%2 == 0 && arr.get(mid).equals(arr.get(mid+1)))) {
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
