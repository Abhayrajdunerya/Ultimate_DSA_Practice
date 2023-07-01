package arrays.easy;

import java.util.LinkedHashSet;

public class _4_Remove_Duplicates_From_Sorted_Array {

    public static int removeDuplicates(int arr[]) {
        int n = arr.length;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        int i = 0;
        for (int x: set) {
            arr[i++] = x;
        }

        return i;
    }

    // Optimal - O(n)
    public static int removeDuplicates_optimal(int arr[]) {
        int n = arr.length;
        int i = 0;

        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        
    }
}
