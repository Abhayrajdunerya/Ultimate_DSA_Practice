package arrays.hard;

public class _9_Count_Inversions {

    // Brute - O(N^2)
    public static int countInversion_brute(int arr[]) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) cnt++;
            }
        }

        return cnt;

    }

    // Optimal - O(nlogn), O(n)
    public static int countInversion_optimal(int arr[], int si, int ei) {
        int invCount = 0;
        if (si < ei) {
            int mid = si+(ei-si)/2;
            invCount = countInversion_optimal(arr, si, mid);
            invCount += countInversion_optimal(arr, mid+1, ei);
            invCount += merge(arr, si, mid+1, ei);
        }

        return invCount;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int invCount = 0;
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid;
        int k = 0;

        while (i < mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid-i);
            }
        }

        while (i < mid) temp[k++] = arr[i++];
        while ( j <= ei) temp[k++] = arr[j++];

        for (i = si, k = 0; i <= ei; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static void main(String[] args) {
        // int arr[] = {5,3,2,4,1};
        int arr2[] = {468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323};

        System.out.println(countInversion_brute(arr2));
        System.out.println(countInversion_optimal(arr2, 0, arr2.length-1));
    }
}
