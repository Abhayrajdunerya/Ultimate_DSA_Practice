package binary_search.hard_search_space;

public class _5_Find_Samllest_Divisor {

    public static int findMax(int arr[]) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static int totSumByDivide(int arr[], int num) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i]/(double)num);
        }

        return sum;
    }
    public static int smallestDivisor(int arr[], int limit) {
        int low = 1;
        int high = findMax(arr);
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            int sum = totSumByDivide(arr, mid);

            if (sum <= limit) {
                high = mid-1;
            } else {
                low = mid+1;
            }

        }

        return low;
    }
    public static void main(String[] args) {
        
    }
}
