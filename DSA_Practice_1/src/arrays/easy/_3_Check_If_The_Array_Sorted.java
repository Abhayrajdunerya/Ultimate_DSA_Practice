package arrays.easy;

public class _3_Check_If_The_Array_Sorted {

    public static boolean isSorted(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }

        return true;

    }
    public static void main(String[] args) {
        
    }
}
