package stack_and_queues.motonic_stack_queue;

public class _3_No_Of_NGEs_To_The_Right {

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int ans[] = new int[queries];
    for (int i = 0; i < queries; i++) {
        int idx = indices[i];
        int count = 0;
        for (int j = idx; j < N; j++) {
            if (arr[idx] < arr[j]) {
                count++;
            }
        }
        ans[i] = count;
    }
    
    return ans;
     
  }
    public static void main(String[] args) {
        
    }
}
