package ds.algos.leetcode.easy;

public class TwoCityScheduling {

    public static void main(String[] args) {

    }

    public static int twoCitySchedCost(int[][] costs) {
        int sum = 0;

        for (int[] cost : costs) {
            sum += Math.min(cost[0], cost[1]);
        }

        return sum;
    }
}
