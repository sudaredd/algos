package ds.algos.leetcode.easy;

public class MaximumProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0)
            return 0;
        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++) {
            if(min > prices[i])
                min = prices[i];
            if(max < prices[i]-min)
                max = prices[i]-min;
        }
        return max;
    }


}
