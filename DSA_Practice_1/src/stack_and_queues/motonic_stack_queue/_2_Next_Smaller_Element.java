package stack_and_queues.motonic_stack_queue;

import java.util.Stack;

public class _2_Next_Smaller_Element {

    public static int[] nextSmaller_right(int[] arr, int n) { 
        // Your code here
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }
            
            s.push(i);
        }
        
        return ans;
    }

    public static int[] nextSmaller_left(int[] arr, int n) { 
        // Your code here
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }
            
            s.push(i);
        }
        
        return ans;
    }

    
    public static void main(String[] args) {
        
    }
}
