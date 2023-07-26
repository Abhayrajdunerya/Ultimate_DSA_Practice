package binary_search.easy_1d;

public class _1_searchANumber {

    public static int search(int []nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        
    }
}