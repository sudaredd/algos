package ds.algos.bbg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int res[] = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));

        res = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 17);
        System.out.println(Arrays.toString(res));

        res = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 8);
        System.out.println(Arrays.toString(res));

    }

    public int[] twoSum(int arr[], int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], i);
            } else {
                return new int[]{map.get(target - arr[i]), i};
            }
        }
        return null;
    }

}
