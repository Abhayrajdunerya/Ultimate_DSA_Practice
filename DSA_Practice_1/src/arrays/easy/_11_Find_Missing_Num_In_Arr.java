package arrays.easy;

public class _11_Find_Missing_Num_In_Arr {

    // Brute - O(n*w)
    public static int missingNum(int arr[]) {
        int n = arr.length;
        
        for (int i = 1; i <= n; i++) {
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                return i;
            }

        }

        return -1;
    }

    // Better - O(2n), O(n)
    public static int missingNum_better(int arr[]) {
        int n = arr.length;
        int hash[] = new int[n+1];

        for (int i = 0; i < n; i++) {
            hash[arr[i]] = 1;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) return i;
        }

        return -1;
    }

    // Optimal 1 - O(n)
    public static int missingNum_optimal(int arr[], int N) {
        int n = arr.length;

        int sn = (N*(N+1))/2;
        int s = 0;

        for (int i = 0; i < n; i++) {
            s += arr[i];
        }

        return sn-s;
    }

    // Optimal 2 - O(n)
    public static int missingNum_optimal_xor(int arr[], int N) {
        int xor1 = 0, xor2 = 0;

        int n = N-1;

        for (int i = 0; i < n; i++) {
            xor1 = xor1^(i+1);
            xor2 = xor2^arr[i];
        }
        xor1 = xor1^N;
        return xor1^xor2;
    }

    public static void main(String[] args) {
        
    }
}
