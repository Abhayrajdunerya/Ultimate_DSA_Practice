package binary_search.easy_1d;

public class _6_Count_Occ_Of_A_Number {

    public static int count(int arr[], int n, int x) {
        int firstOcc = firstOcc(arr, x);
        int lastOcc = lastOcc(arr, x);

        if (firstOcc == -1 && lastOcc == -1) return 0;

        int ans = lastOcc-firstOcc+1;

        return ans;
    }

    public static int firstOcc(int[] arr, int k) {
        int si = 0;
        int ei = arr.length-1;
        int mid;
        int ans = -1;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr[mid] == k) {
                ans = mid;
                ei = mid-1;
            } else if (arr[mid] < k) {
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }

        return ans;
    }

    public static int lastOcc(int[] arr, int k) {
        int si = 0;
        int ei = arr.length-1;
        int mid;
        int ans = -1;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr[mid] == k) {
                ans = mid;
                si = mid+1;
            } else if (arr[mid] < k) {
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
