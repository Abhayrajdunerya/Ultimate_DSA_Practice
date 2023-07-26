package binary_search.hard_search_space;

import java.util.ArrayList;

public class _14_Painters_Partition {

    public static int[] max_and_sum(ArrayList<Integer> arr) {
        int max = arr.get(0);
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            max = Math.max(max, arr.get(i));
        }

        int ans[] = {max, sum};

        return ans;
    }

    public static boolean possible(ArrayList<Integer> arr, int k, int limit) {
        int painters = 1;
        int areaOftime = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (areaOftime + arr.get(i) <= limit) {
                areaOftime += arr.get(i);
            } else {
                painters++;
                areaOftime = arr.get(i);
            }

            if (painters > k) {
                return false;
            }
        }

        return true;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int[] max_and_sum = max_and_sum(boards);
        int low = max_and_sum[0];
        int high = max_and_sum[1];
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            if (possible(boards, k, mid)) {
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
