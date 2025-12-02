import java.util.*;

class SubsetSum{
   	static boolean isSubsetSumRec(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        // If last element is greater than 
      	// sum, ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSumRec(arr, n - 1, sum);
        }
        return isSubsetSumRec(arr, n - 1, sum) || 
               isSubsetSumRec(arr, n - 1, sum - arr[n - 1]);
    }

    static boolean isSubsetSum(int[] arr, int sum) {
        return isSubsetSumRec(arr, arr.length, sum);
    }
    public static void main(String[] args) {
        int[] arr = {31, 34, 8, 12, 6, 3};
        int sum = 9;
        if (isSubsetSum(arr, sum)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
