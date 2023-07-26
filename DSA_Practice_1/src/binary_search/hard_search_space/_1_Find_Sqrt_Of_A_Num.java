package binary_search.hard_search_space;

public class _1_Find_Sqrt_Of_A_Num {

    public static int sqrtN(long N) {
		long low = 1;
		long high = N;
		long mid;

		while (low <= high) {
			mid = low+(high-low)/2;

			if (mid * mid > N) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}

		return (int) high;
	}
    public static void main(String[] args) {
        
    }
}
