package dynamic_programming.dp_subsequences;

public class _3_Partition_Set_Into_2_Subset_With_Min_Abs_Sum_Diff {

    // Space Optimization - O(N*M), O(M) 
    public static int isPartitioned_spaceOptimization(int arr[], int n, int target) {
        boolean prev[] = new boolean[target+1];

        prev[0] = true;
        for (int i = 1; i < target; i++) {
            prev[i] = false;
        }

        for (int ind = 1; ind <= n; ind++) {
            boolean curr[] = new boolean[target+1];
            curr[0] = true;
            for (int tg = 1; tg <= target; tg++) {
                if (arr[ind-1] <= tg) {
                    boolean take = prev[tg-arr[ind-1]];
                    boolean notTake = prev[tg];

                    curr[tg] = take || notTake;
                } else {
                    curr[tg] = prev[tg];
                }
            }

            prev = curr;
        }

        int minDiff = (int) Math.pow(10, 9);
        
        for (int i = 0; i <= target; i++) {
            if (prev[i]) {
                int diff = Math.abs(i-(target-i));
                minDiff = Math.min(minDiff, diff);
            }
        }
        
        return minDiff;
    }
    public static void main(String[] args) {
        // Your code goes here
	    // int sum = 0;
	    // for (int i = 0; i < n; i++) {
	    //     sum += arr[i];
	    // }
	    
	    // return isPartitioned_spaceOptimization(arr, n, sum);
    }
}
