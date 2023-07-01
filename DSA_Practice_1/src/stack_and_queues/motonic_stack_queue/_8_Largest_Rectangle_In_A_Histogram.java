package stack_and_queues.motonic_stack_queue;

import java.util.Stack;

public class _8_Largest_Rectangle_In_A_Histogram {

    public static long[] nextSmaller_right(long[] arr, int n) { 
        // Your code here
        long[] ans = new long[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return ans;
    }

    public static long[] nextSmaller_left(long[] arr, int n) { 
        // Your code here
        long[] ans = new long[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return ans;
    }
    
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long[] nsl = nextSmaller_left(hist, (int)n);
        long[] nsr = nextSmaller_right(hist, (int)n);
        
        long maxArea = 0;
        for (int i = 0; i < n; i++) {
            long height = hist[i];
            long width = nsr[i]-nsl[i]-1;
            long currArea = height*width;
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
    public static void main(String[] args) {
        
    }
}
