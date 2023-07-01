package arrays.hard;

public class _10_Reverse_Pairs {

    // O(N^2)
    public static int reversePair_brute(int arr[]) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > 2*arr[j]) cnt++;
            }
        }

        return cnt;
    }

    // O(nlogn), O(n)
    public static int reversePair_optimal(int arr[], int si, int ei) {
        int cnt = 0;
        if (si < ei) {
            int mid = si+(ei-si)/2;

            cnt = reversePair_optimal(arr, si, mid);
            cnt += reversePair_optimal(arr, mid+1, ei);
            cnt += merge(arr, si, mid, ei);
        }

        return cnt;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int cnt = 0;
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        
        for (i = si; i <= mid; i++) {
            while(j <= ei && arr[i] > (2*(long)arr[j])) {
                j++;
            }
            cnt += (j-(mid+1));
        }
        
        int k = 0;
        i = si;
        j = mid+1;
        

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= ei) temp[k++] = arr[j++];

        for (i = si, k = 0; i <= ei; i++, k++) {
            arr[i] = temp[k];
        }

        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = {40, 25, 19, 12, 9, 6, 2};

        System.out.println(reversePair_brute(arr));
        System.out.println(reversePair_optimal(arr, 0, arr.length-1));
    }
}
