class Solution {
    public int minimumDeletions(int[] nums) {
        int mini,maxi;
        mini=0;
        maxi=0;
        int i=0;
        while(i<nums.length)
        {
            
            if(nums[i]>nums[maxi])
            {
                maxi=i;
            }
            if(nums[i]<nums[mini])
            {
                mini=i;
            }
            i++;
        }
        int deletestart= Math.max(mini,maxi)+1;
        int deleteend=nums.length-Math.min(maxi,mini);
        int deletestartend=1+mini+nums.length-maxi;
        int deleteendstart=1+maxi+nums.length-mini;
        int mindeletions=Math.min(deletestart,deleteend);
        mindeletions=Math.min(mindeletions,deletestartend);
        mindeletions=Math.min(mindeletions, deleteendstart);


        return mindeletions;

        
    }
}