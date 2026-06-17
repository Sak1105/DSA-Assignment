import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;
        int totalSum = 0;

        for (int x : nums)
            totalSum += x;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        generate(left, leftSums);
        generate(right, rightSums);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int leftCount = 0; leftCount <= n; leftCount++) {

            int rightCount = n - leftCount;

            for (int leftSum : leftSums[leftCount]) {

                double target = totalSum / 2.0 - leftSum;

                List<Integer> list = rightSums[rightCount];

                int idx = Collections.binarySearch(
                        list,
                        (int)Math.ceil(target));

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < list.size()) {
                    int chosenSum = leftSum + list.get(idx);
                    ans = Math.min(ans,
                            Math.abs(totalSum - 2 * chosenSum));
                }

                if (idx > 0) {
                    int chosenSum = leftSum + list.get(idx - 1);
                    ans = Math.min(ans,
                            Math.abs(totalSum - 2 * chosenSum));
                }
            }
        }

        return ans;
    }

    private void generate(int[] arr, List<Integer>[] sums) {

        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {

            int count = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    count++;
                    sum += arr[i];
                }
            }

            sums[count].add(sum);
        }
    }
}