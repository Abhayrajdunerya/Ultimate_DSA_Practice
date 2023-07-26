package recursion.subsequence_pattern;

import java.util.ArrayList;

public class _1_Binary_Str_With_No_Consecutive_1s {

    public static void solve_1(int i, int n, ArrayList<String> ans, String str, int prev) {
		if (i == n) {
			ans.add(str);
			return;
		}


		if (prev == 0) {
			solve_1(i+1, n, ans, str+"0", 0);
			solve_1(i+1, n, ans, str+"1", 1);
		} else {
			solve_1(i+1, n, ans, str+"0", 0);
		}
	}
	public static ArrayList<String> generateString(int k) {
		ArrayList<String> ans = new ArrayList<>();
		solve_1(0, k, ans, "", 0);

		return ans;
	}
    public static void main(String[] args) {
        System.out.println(generateString(20));
    }
}
