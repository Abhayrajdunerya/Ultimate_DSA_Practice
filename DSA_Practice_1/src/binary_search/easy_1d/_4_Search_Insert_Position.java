package binary_search.easy_1d;

public class _4_Search_Insert_Position {

    public static int searchInsert(int [] arr, int m){
        int low = 0;
        int high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (arr[mid] == m) return mid;

            if (arr[mid] < m) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        
    }
}
