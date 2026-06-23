class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
    int left=1;
    int right=piles[0];
    int k=0;
    for(int i=0;i<n;i++){
        right=Math.max(right,piles[i]);
    }
    while(left<right){
        int mid=left+(right-left)/2;
        int hrs=0;
        for(int i=0;i<n;i++){
            hrs=hrs+piles[i]/mid;
            if(piles[i]%mid!=0){
                hrs++;
            }
        }
       
         if(hrs<=h){
            right=mid;
        }
        else {
            left=mid+1;
        }
    }
return left;
}}