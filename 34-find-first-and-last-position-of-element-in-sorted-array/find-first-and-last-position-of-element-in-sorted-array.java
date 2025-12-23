class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=findLast(nums,target,nums.length-1);
        int f=findFirst(nums,target,0);
        int[] res={f,l};
        return res;
    }
    private static int findFirst(int[] nums, int target, int pos){
        if(pos==nums.length|| nums[pos]>target)
        {
            return -1;
        }
        if(nums[pos]==target){
            return pos;
        }
        return findFirst(nums,target,pos+1);
    }
    private static int findLast(int[] nums, int target, int pos){
        if(pos==-1||nums[pos]<target)
        {
            return -1;
        }
        if(nums[pos]==target){
            return pos;
        }
        return findLast(nums,target,pos-1);
    }
}