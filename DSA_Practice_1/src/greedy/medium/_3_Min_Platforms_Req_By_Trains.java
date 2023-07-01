package greedy.medium;

import java.util.Arrays;

public class _3_Min_Platforms_Req_By_Trains {

    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1;
        int j = 0;
        int cnt = 1;
        int max = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }

            max = Math.max(max, cnt);
        }

        return max;

    }

    public static void main(String[] args) {

    }
}
