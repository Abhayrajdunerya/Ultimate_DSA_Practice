package binary_search.easy_1d;

public class _2_floor {

    public static int floor(int arr[], int k) {
        int si = 0;
        int ei = arr.length-1;
        int mid;
        int floor = -1;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr[mid] <= k) {
                floor = arr[mid];
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }

        return floor;
    }
    public static void main(String[] args) {
        
    }
}
