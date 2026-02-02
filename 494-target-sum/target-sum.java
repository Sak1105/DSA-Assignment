class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = index + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        int add = dfs(nums, index + 1, sum + nums[index], target);
        int subtract = dfs(nums, index + 1, sum - nums[index], target);

        memo.put(key, add + subtract);
        return add + subtract;
    }
}
