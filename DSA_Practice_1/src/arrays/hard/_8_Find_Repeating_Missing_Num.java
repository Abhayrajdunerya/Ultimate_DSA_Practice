package arrays.hard;

public class _8_Find_Repeating_Missing_Num {

    // Brute - O(n^2)
    public static int[] findRepMissNums_brute(int arr[]) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    cnt++;
                }
            }
            if (cnt > 1) repeating = i;
            else if (cnt == 0) missing = i;
        }

        int ans[] = {repeating, missing};

        return ans;
    }

    // Better - O(2N), O(N)
    public static int[] findRepMissNums_better(int arr[]) {
        int n = arr.length;
        int map[] = new int[n+1];
        
        int repeating = -1, missing = -1;

        for (int i = 0; i < n; i++) {
            map[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (map[i] > 1) repeating = i;
            else if (map[i] == 0) missing = i;
            
            if (repeating != -1 && missing != -1) break;
        }

        int ans[] = {repeating, missing};

        return ans;

    }

    // Optimal - O(N)
    public static int[] findRepMissNums_optimal(int arr[]) {
        long n = arr.length;
        long sn = (n*(n+1))/2;
        long sn2 = (n*(n+1)*(2*n+1))/6;
        long s = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            s2 += (long) arr[i] * (long) arr[i];
        }

        long val1 = s-sn;
        long val2 = s2-sn2;
        
        val2 = val2/val1;

        long x = (val1+val2)/2;
        long y = x-val1;
        int ans[] = {(int) x, (int) y};

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
