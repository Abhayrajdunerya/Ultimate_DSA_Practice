package binary_search.hard_search_space;

import java.util.ArrayList;

public class _9_Book_Allocation_Problem {

    public static int[] max_and_sum(ArrayList<Integer> arr) {
        int max = arr.get(0);
        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int ans[] = {max, sum};

        return ans;
    }

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int cntStudent = 1;
        int studentPages = 0; 

        for (int i = 0; i < arr.size(); i++) {
            if (studentPages+arr.get(i) <= pages) {
                studentPages += arr.get(i);
            } else {
                cntStudent++;
                studentPages = arr.get(i);
            }
        }

        return cntStudent;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int[] max_ans_sum = max_and_sum(arr);
        int low = max_ans_sum[0];
        int high = max_ans_sum[1];
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            int students = countStudents(arr, mid);

            if (students > m) {
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
