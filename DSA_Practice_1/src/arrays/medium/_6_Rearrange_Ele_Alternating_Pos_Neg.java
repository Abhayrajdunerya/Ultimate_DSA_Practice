package arrays.medium;

import java.util.ArrayList;

public class _6_Rearrange_Ele_Alternating_Pos_Neg {

    // Brute - O(2n), O(n)
    public static void rearrange_brute(int arr[]) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neg.add(arr[i]);
            } else {
                pos.add(arr[i]);
            }
        }

        if (pos.size() < neg.size()) {
            for (int i = 0; i < pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size()*2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index++] = neg.get(i);
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size()*2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index++] = pos.get(i);
            }
        }
    }

    // Optimal - O(n), O(n)
    public static int[] rearrange_optimal(int arr[]) {
        int n = arr.length;

        int ans[] = new int[n];
        int posIdx = 0, negIdx = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIdx] = arr[i];
                negIdx += 2;
            } else {
                ans[posIdx] = arr[i];
                posIdx += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
