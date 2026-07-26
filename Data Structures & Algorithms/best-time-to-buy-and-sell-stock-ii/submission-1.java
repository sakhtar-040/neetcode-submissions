class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i=0;
        while(i<prices.length){
            int j=i+1;
            int tempProfite = 0;
            while(j<prices.length){
                if(prices[j]<prices[i]){
                    i = j;
                    break;
                } else {
                    if(prices[j]-prices[i] < tempProfite){
                        i = j;
                        break;
                    }
                    tempProfite = Math.max(tempProfite,prices[j]-prices[i]);
                    j++;
                }
            }
            maxProfit = maxProfit + tempProfite;
            if(j == prices.length) break;
        }
        return maxProfit;
    }
}