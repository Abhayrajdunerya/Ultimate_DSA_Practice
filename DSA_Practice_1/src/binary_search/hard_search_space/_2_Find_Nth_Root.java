package binary_search.hard_search_space;

public class _2_Find_Nth_Root {

    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;

            int midN = check(n, m, mid);

            if (midN == 1) return mid;
            else if (midN == 0) low = mid+1;
            else high = mid-1;

        }

        return -1;
    }

    // 2 - num is bigger
    // 1 - num is perfect
    // 0 - num is smaller
    public static int check(int n, int m, int num) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= num;

            if (ans > m) return 2;
        }

        if (ans == m) return 1;

        return 0;
    }
    public static void main(String[] args) {
        
    }
}
