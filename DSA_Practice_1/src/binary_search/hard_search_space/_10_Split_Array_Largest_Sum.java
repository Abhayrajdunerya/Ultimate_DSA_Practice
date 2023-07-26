package binary_search.hard_search_space;

public class _10_Split_Array_Largest_Sum {

    public static int[] max_and_sum(int arr[]) {
        int max = arr[0];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int ans[] = {max, sum};

        return ans;
    }

    public static int countSubArr(int arr[], int capacity) {
        int subArrCount = 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= capacity) {
                sum += arr[i];
            } else {
                subArrCount++;
                sum = arr[i];
            }
        }

        return subArrCount;
    }
    public static int largestSubarraySumMinimized(int []a, int k) {
        int max_and_sum[] = max_and_sum(a);
        int low = max_and_sum[0];
        int high = max_and_sum[1];
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            int subArrCount = countSubArr(a, mid);

            if (subArrCount > k) {
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
