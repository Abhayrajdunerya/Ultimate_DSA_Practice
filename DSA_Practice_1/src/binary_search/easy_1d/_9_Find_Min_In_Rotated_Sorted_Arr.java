package binary_search.easy_1d;

public class _9_Find_Min_In_Rotated_Sorted_Arr {

    public static int findMin(int []arr) {
        int si = 0;
        int ei = arr.length-1;
        int mid;

        int ans = Integer.MAX_VALUE;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr[si] <= arr[mid]) {
                ans = Math.min(ans, arr[si]);
                si = mid+1;
            } else {
                ans = Math.min(ans, arr[mid]);
                ei = mid-1;
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
