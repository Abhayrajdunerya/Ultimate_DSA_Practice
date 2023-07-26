package binary_search.hard_search_space;

public class _4_Min_Days_To_Make_M_Bouquets {

    public static int[] findMinMax(int arr[]) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int ans[] = {min, max};

        return ans;
    }

    public static boolean possible(int arr[], int r, int b, int days) {
        int cnt = 0;
        int maxBouquets = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= days) {
                cnt++;
            } else {
                maxBouquets += (cnt/r);
                cnt = 0;
            }
        }

        maxBouquets += (cnt/r);

        return maxBouquets >= b;
    }

    public static int roseGarden(int[] arr, int r, int b) {
        int n = arr.length;

        if (r*b > n) return -1;

        int minMax[] = findMinMax(arr);
        int low = minMax[0];
        int high = minMax[1];
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (possible(arr, r, b, mid)) {
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
