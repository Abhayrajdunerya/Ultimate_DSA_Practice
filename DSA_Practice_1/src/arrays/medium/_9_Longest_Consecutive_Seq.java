package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;

public class _9_Longest_Consecutive_Seq {

    public static boolean search(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) return true;
        }

        return false;
    }

    // Brute - O(n^3)
    public static int longestConseqSeq_brute(int arr[]) {
        int n = arr.length;

        int maxSeq = 1;
        

        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            int currSeq = 1;
            for (int j = 1; j < n; j++) {
                if (search(arr, ele+j)) {
                    currSeq++;
                    maxSeq = Math.max(maxSeq, currSeq);
                } else {
                    break;
                }
            }
        }

        return maxSeq;
    }

    // Better - O(nlogn)
    public static int longestConseqSeq_better(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int maxLen = 1;
        int ele = arr[0];
        int currLen = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == ele+1) {
                currLen++;
                ele = arr[i];
                maxLen = Math.max(maxLen, currLen);
            } else if (arr[i] == ele) {
                
            } else {
                currLen = 1;
                ele = arr[i];
            }
        }

        return maxLen;
    }

    // O(n), O(n)
    public static int longestConseqSeq_optimal(int arr[]) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        int longestSeq = 0;
        for (int num : arr) {
            if (!set.contains(num-1)) {
                int currSeq = 1;
                int currNum = num;
                while (set.contains(currNum+1)) {
                    currNum++;
                    currSeq++;
                }

                longestSeq = Math.max(currSeq, longestSeq);
            }
        }

        return longestSeq;
    }

    public static void main(String[] args) {
        int arr[] = {102, 4, 100, 1, 101, 3, 2, 1, 1};
        System.out.println(longestConseqSeq_brute(arr));
        System.out.println(longestConseqSeq_better(arr));
        System.out.println(longestConseqSeq_optimal(arr));
    }
}
