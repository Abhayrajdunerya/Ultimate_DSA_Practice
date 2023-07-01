package stack_and_queues.motonic_stack_queue;

import java.util.Stack;

public class _9_Maximal_Rectangles {

    public static int[] nextSmaller_right(int[] arr, int n) { 
        // Your code here
        int[] ans = new int[n];
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
                ans[i] = s.peek();
            }
            
            s.push(i);
        }
        
        return ans;
    }
    
    public static int maxAreaInHistogram(int hist[], int n) {
        // your code here
        int[] nsl = nextSmaller_left(hist, n);
        int[] nsr = nextSmaller_right(hist, n);
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = hist[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height*width;
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
    
    public static int maxArea_sol(int mat[][], int n, int m) {
        int maxArea = 0;
        
        int heights[] = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    heights[j] += mat[i][j];
                } else {
                    heights[j] = 0;
                }
            }
            int currArea = maxAreaInHistogram(heights, m);
            maxArea = Math.max(currArea, maxArea);
        }
        
        return maxArea;
    }
    
    
    
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        return maxArea_sol(M, n, m);
    }
    public static void main(String[] args) {
        
    }
}
