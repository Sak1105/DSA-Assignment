public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    int k=j;
                    while(k<nums2.length){
                        if(nums2[j]<nums2[k]){
                            ans[i]=nums2[k];
                           break;
                        }
                        k++;
                    }
                    if(k==nums2.length){
                        ans[i]=-1;
                    }
                    
                }
            }
            
        }
        return ans;
    }
}