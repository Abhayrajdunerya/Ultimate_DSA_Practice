package stack_and_queues.implementation_problems;

import java.util.Stack;

public class _2_Stock_Span_Problem {

    // O(N), O(N)
    public static int[] stockSpan(int prices[], int n) {
        int span[] = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && prices[s.peek()] <= prices[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            
            s.push(i);
        }
        
        return span;
    }
    public static void main(String[] args) {
        
    }
}
