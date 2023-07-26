package binary_search.easy_1d;

public class _3_ceil {

    public static int ceil(int arr[], int k) {
        int si = 0;
        int ei = arr.length-1;
        int mid;
        int ceil = -1;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr[mid] < k) {
                si = mid+1;
            } else {
                ceil = arr[mid];
                ei = mid-1;
            }
        }

        return ceil;
    }
    public static void main(String[] args) {
        
    }
}
