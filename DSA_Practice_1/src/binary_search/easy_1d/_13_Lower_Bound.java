package binary_search.easy_1d;

public class _13_Lower_Bound {

    public static int lowerBound(int []arr, int n, int x) {
        int ans = n;
        int low = 0;
        int high = n-1;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
