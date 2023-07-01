package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _7_Next_Permutation {

    public static List<Integer> nextPermutation(int arr[]) {
        int n = arr.length;
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(arr[i]);
        }

        int ind = -1;

        // Finding break-point
        for (int i = n-2; i >= 0; i--) {
            if (A.get(i) < A.get(i+1)) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            Collections.reverse(A);
        } 

        for (int i = n-1; i >= 0; i--) {
            if (arr[i] > arr[ind]) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        List<Integer> subList = A.subList(ind+1, n);
        Collections.reverse(subList);

        return A;
    }

    
    public static void main(String[] args) {
        
    }
}
