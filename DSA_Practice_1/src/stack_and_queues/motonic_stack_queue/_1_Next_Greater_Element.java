package stack_and_queues.motonic_stack_queue;

import java.util.Stack;

public class _1_Next_Greater_Element {

    public static int[] nextGreater_right(int[] arr, int n) { 
        // Your code here
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
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

    public static int[] nextGreater_left(int[] arr, int n) { 
        // Your code here
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
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

    public static int[] nextGreater_2_Circular_Arr(int[] arr, int n) { 
        // Your code here
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        Stack<Integer> stk = new Stack<>();
        
        for (int i = n-1; i >= 0; i--) {
            stk.push(i);
        }
        
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
                    stk.pop();
                }
                
                if (stk.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = arr[stk.peek()];
                }
                
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
