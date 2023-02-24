
/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/*/
class Solution {
    public int maxProfit(int[] prices) {
        int gret=Integer.MAX_VALUE;//least so fat
        int overallprofi=0;
        int pifsoldt=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<gret){
           gret=prices[i];
            }
            pifsoldt=prices[i]-gret;
            if(overallprofi<pifsoldt){
                overallprofi=pifsoldt;
            }
        }
        return overallprofi;
    }

}
