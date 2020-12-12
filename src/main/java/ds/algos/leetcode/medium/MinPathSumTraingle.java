package ds.algos.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class MinPathSumTraingle {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(list));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {

       List<Integer> last = triangle.get(triangle.size()-1);

//        Integer []res = new Integer[last.size()];

        Integer[] res = last.toArray(new Integer[0]);

        for(int i=triangle.size()-2; i>=0; i--) {
            List<Integer> list = triangle.get(i);
            for(int j=0; j<i+1; j++) {
                int min = Math.min(res[j], res[j+1]);
                res[j] = min + list.get(j);
            }
        }
        return res[0];
    }

}
