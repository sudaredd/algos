package ds.algos.bbg_practice;


public class BuysSellStock {

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        BuysSellStock bestTimeBuySellStock = new BuysSellStock();
        System.out.println(bestTimeBuySellStock.maxProfit(arr));
        System.out.println(bestTimeBuySellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    private int maxProfit(int[] arr) {
        int min = arr[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - min);
            if (arr[i] < min)
                min = arr[i];

        }
        return max;
    }
}
