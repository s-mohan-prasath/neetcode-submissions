class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1)return 0;
        int minPrice = prices[0];
        int maxProfit = 0,profit;
        for(int i = 1;i<n;i++){
            if(minPrice >= prices[i]){
                minPrice = prices[i];
            }else{
                profit = prices[i] - minPrice;   
                if(profit>maxProfit)maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
