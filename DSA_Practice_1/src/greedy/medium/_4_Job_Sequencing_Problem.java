package greedy.medium;

import java.util.Arrays;

public class _4_Job_Sequencing_Problem {

    public static class Job {
        int id;
        int deadline;
        int profit;

        Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    public static int[] maxProfit(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit-a.profit);
        
        int maxDeadline = 0;
        
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        
        int result[] = new int[maxDeadline+1];
        Arrays.fill(result, -1);
        
        int maxProfit = 0;
        int jobCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    maxProfit += arr[i].profit;
                    jobCount++;
                    break;
                }
            }
        }
        
        int ans[] = {jobCount, maxProfit};
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
