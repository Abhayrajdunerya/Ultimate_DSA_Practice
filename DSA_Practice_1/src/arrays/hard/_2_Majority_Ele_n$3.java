package arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class _2_Majority_Ele_n$3 {

    // Brute - O(n^2)
    public static ArrayList<Integer> majorityEle_brute(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            if (ans.size() == 0 || arr[i] != ans.get(0)) {

                for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j])
                        cnt++;
                }
                if (cnt > n/3) ans.add(arr[i]);
            }
                
            if (ans.size() == 2) break;
        }

        return ans;
    }

    // Better - O(2n), O(n)
    public static ArrayList<Integer> majorityEle_better(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > n/3) {
                ans.add(key);
            }
        }

        return ans;
    }

    // Optimal - O(n)
    public static ArrayList<Integer> majorityEle_optimal(int arr[]) {
        int n = arr.length;
        ArrayList <Integer> ans = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && arr[i] != ele2) {
                cnt1 = 1;
                ele1 = arr[i];
            } else if (cnt2 == 0 && arr[i] != ele1) {
                cnt2 = 1;
                ele2 = arr[i];
            } else if (arr[i] == ele1) {
                cnt1++;
            } else if (arr[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele1) cnt1++;
            if (arr[i] == ele2) cnt2++;
        }

        if (cnt1 > n/3) ans.add(ele1);
        if (cnt2 > n/3) ans.add(ele2);

        return ans;
    }


    public static void main(String[] args) {
        
    }
}
