package binary_search.hard_search_space;

public class _7_Kth_Missing_Positive_Num {

    public static int missingK(int[] vec, int n, int k) {
        int low = 0;
        int high = n-1;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;
            int missing = vec[mid]-mid-1;

            if (missing < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return low+k;
    }
    public static void main(String[] args) {
        
    }
}
