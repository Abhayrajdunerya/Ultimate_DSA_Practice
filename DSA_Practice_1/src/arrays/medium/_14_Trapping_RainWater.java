package arrays.medium;

public class _14_Trapping_RainWater {

    public static long trappingWater(int arr[], int n) {
        long totalWater = 0;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int height = Math.min(leftMax[i], rightMax[i]);
            int width = 1;
            int trappedWater = (height - arr[i]) * width;
            totalWater += trappedWater;
        }

        return totalWater;
    }

    public static void main(String[] args) {

    }
}
