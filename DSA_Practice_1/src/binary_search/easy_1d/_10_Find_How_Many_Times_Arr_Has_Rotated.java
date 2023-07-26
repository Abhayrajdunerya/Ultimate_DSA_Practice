package binary_search.easy_1d;

public class _10_Find_How_Many_Times_Arr_Has_Rotated {

    public static int findKRotation(int []arr){
        
        int si = 0;
        int ei = arr.length-1;
        int mid;

        int ans = 0;

        while (si <= ei) {
            mid = si+(ei-si)/2;

            if (arr[si] <= arr[mid]) {
                if (arr[ans] > arr[si]) {
                    ans = si;
                }
                si = mid+1;
            } else {
                if (arr[ans] > arr[mid]) {
                    ans = mid;
                }
                ei = mid-1;
            }

        }

        return ans;

    }
    public static void main(String[] args) {
        
    }
}
