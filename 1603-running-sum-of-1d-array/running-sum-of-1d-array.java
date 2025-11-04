class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum=new int[nums.length];
        int calsum=0;

        for(int i=0;i<nums.length;i++)
        {
            calsum=calsum+nums[i];
            sum[i]=calsum;
        }
        return sum;
        
    }
}