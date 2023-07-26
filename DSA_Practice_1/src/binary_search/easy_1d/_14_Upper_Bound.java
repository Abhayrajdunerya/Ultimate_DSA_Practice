package binary_search.easy_1d;

public class _14_Upper_Bound {

    public static int upperBound(int []arr, int x, int n){
        int ans = n;
        int low = 0;
        int high = n-1;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (arr[mid] > x) {
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
