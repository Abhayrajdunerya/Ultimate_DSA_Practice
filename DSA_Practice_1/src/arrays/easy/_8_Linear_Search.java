package arrays.easy;

public class _8_Linear_Search {

    public static int search(int arr[], int K) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == K) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        
    }
}
