package stack_and_queues.implementation_problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _1_Sliding_Window_Maximum {

    public static class Pair implements Comparable<Pair> {
        int idx;
        int val;
        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
        
        @Override
        public int compareTo(Pair p2) {
            return p2.val-this.val;
        }
    }

    //Function to find maximum of each subarray of size k.
    
    public static ArrayList<Integer> maxOfAllSubArrOfSizeK(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, arr[i]));
        }
        
        ans.add(pq.peek().val);
        for (int i = k; i < n; i++) {
            while (!pq.isEmpty() && pq.peek().idx <= i-k) {
                pq.remove();
            }
            
            pq.add(new Pair(i, arr[i]));
            
            ans.add(pq.peek().val);
            
        }
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
