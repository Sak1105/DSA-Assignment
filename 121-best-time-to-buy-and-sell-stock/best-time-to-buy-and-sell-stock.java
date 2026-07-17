class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit=0;
      int minPrice=prices[0];
      int n=prices.length;
        for(int i=0;i<n;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                int profit=prices[i]-minPrice;
                maxProfit=Math.max(profit,maxProfit);
            }
            
        }
        return maxProfit;
    }
}
