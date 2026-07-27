class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int n=prices.length;
        int buy_price=prices[0];
        for(int i=1;i<n;i++){
            int currProfit=prices[i]-buy_price;
            if(currProfit>maxProfit){
                maxProfit=currProfit;
            }
            if(prices[i]<buy_price){
                buy_price=prices[i];
            }
        }
        return maxProfit;
    }
}
