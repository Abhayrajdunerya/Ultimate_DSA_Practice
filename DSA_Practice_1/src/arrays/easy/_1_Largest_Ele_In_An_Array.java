package arrays.easy;

public class _1_Largest_Ele_In_An_Array {

    public static int largest(int arr[]) {
        int n = arr.length;

        int lg = arr[0];

        for (int i = 0; i < n; i++) {
            lg = Math.max(lg, arr[i]);
        }

        return lg;
    }

    public static void main(String[] args) {
        
    }
}
