package binary_search.hard_search_space;

public class _6_Ship_Capacity {

    public static int[] maxEle_and_Sum(int arr[]) {
        int max = arr[0];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int ans[] = {max, sum};

        return ans;
    }

    public static int getTotalDays(int weights[], int capacity) {
        int days = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load+weights[i] > capacity) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return days;
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        int[] maxEle_and_Sum = maxEle_and_Sum(weights);

        int low = maxEle_and_Sum[0];
        int high = maxEle_and_Sum[1];
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            int days = getTotalDays(weights, mid);

            if (days > d) {
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
