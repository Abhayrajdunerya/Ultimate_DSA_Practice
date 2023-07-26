package sorting.array;

public class _3_Insertion_Sort {

    public static void insertionSort(int arr[], int n) {
        for (int curr = 1; curr < n; curr++) {
            int prev = curr - 1;
            int currEle = arr[curr];
            while (prev >= 0 && arr[prev] > currEle) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = currEle;
        }
    }

    public static void main(String[] args) {

    }
}
