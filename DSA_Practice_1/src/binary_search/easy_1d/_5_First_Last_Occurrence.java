package binary_search.easy_1d;

import java.util.ArrayList;

public class _5_First_Last_Occurrence {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int firstOcc = firstOcc(arr, k);
        int lastOcc = lastOcc(arr, k);

        int ans[] = {firstOcc, lastOcc};

        return ans;
    }

    public static int firstOcc(ArrayList<Integer> arr, int k) {
        int si = 0;
        int ei = arr.size()-1;
        int mid;
        int ans = -1;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr.get(mid) == k) {
                ans = mid;
                ei = mid-1;
            } else if (arr.get(mid) < k) {
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }

        return ans;
    }

    public static int lastOcc(ArrayList<Integer> arr, int k) {
        int si = 0;
        int ei = arr.size()-1;
        int mid;
        int ans = -1;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr.get(mid) == k) {
                ans = mid;
                si = mid+1;
            } else if (arr.get(mid) < k) {
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
