package arrays.medium;

public class _4_Max_Sub_Arr_Sum {

    // Brute - O(n^3)
    public static int maxSubArraySum_brute(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Better - O(n^2)
    public static int maxSubArraySum_better(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[i];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Optimal - O(n)
    public static int maxSubArraySum_optimal_kadance_algo(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) currSum = 0;
        }

        return maxSum;
    }

    // Print subarray having max. sum
    public static void maxSubArraySum_print(int arr[]) {
        int n = arr.length;
        long maxi = Integer.MIN_VALUE;
        long sum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {
            if (sum == 0) start = i;
            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("The subarray is: [ ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
        System.out.println("Max Subarray Sum = " + maxi);
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        maxSubArraySum_print(arr);
    }
}
