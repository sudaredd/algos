package ds.algos.leetcode.medium;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int res = 1;
        int zero_exists = 0;
        int productNonZero = 1;
        int zeroPos = -1;

        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            res = res * num;
            if (num == 0) {
                zero_exists++;
                zeroPos = i;
            } else {
                productNonZero = productNonZero * num;
            }
        }

        if (res != 0)
            for (int i = 0; i < nums.length; i++) {
                result[i] = res / nums[i];
            }
        else if (zero_exists == 1) {
            result[zeroPos] = productNonZero;
        }
        return result;
    }
}
