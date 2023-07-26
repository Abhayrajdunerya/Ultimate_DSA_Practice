package binary_search.easy_1d;

public class _8_Search_In_A_Rotated_Sorted_Array_2 {

    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        int lo = 0;
        int hi = A.length-1;
        int mid;

        while (lo <= hi) {
            mid = lo+(hi-lo)/2;

            if (A[mid] == key) return true;

            if (A[mid] == A[lo] && A[mid] == A[hi]) {
                lo++;
                hi--;

                continue;
            }

            if (A[lo] <= A[mid]) {
                if (key >= A[lo] && key <= A[mid]) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else {
                if (key >= A[mid] && key <= A[hi]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        
    }
}
