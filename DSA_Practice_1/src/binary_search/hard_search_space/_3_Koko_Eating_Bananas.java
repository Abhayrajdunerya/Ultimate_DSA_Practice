package binary_search.hard_search_space;

public class _3_Koko_Eating_Bananas {

    public static int getHours(int arr[], int rate) {
        int totalHrs = 0;

        for (int i = 0; i < arr.length; i++) {
            totalHrs += Math.ceil((double) arr[i]/(double)rate);
        }

        return totalHrs;
    }

    public static int findMax(int arr[]) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
    public static int minimumRateToEatBananas(int []v, int h) {
        int low = 1;
        int high = findMax(v);
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            int totalHrs = getHours(v, mid);

            if (totalHrs <= h) {
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
