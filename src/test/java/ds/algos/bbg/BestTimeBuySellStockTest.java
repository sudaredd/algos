package ds.algos.bbg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeBuySellStockTest {

    private BestTimeBuySellStock bestTimeBuySellStock = new BestTimeBuySellStock();
    @Test
    void maxProfit() {

        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeBuySellStock.maxProfit(arr));
        System.out.println(bestTimeBuySellStock.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}