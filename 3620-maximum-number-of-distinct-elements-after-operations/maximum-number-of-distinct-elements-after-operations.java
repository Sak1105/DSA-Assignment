import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        long last = Long.MIN_VALUE;
        int ans = 0;

        for (int x : nums) {
            long L = (long) x - k;
            long R = (long) x + k;
            long candidate = Math.max(L, last + 1);
            if (candidate <= R) {
                ans++;
                last = candidate;
            }
        }
        return ans;
    }
}