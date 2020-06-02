package ds.algos.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));

    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<Integer>();
        int ssum = sum(n);
        while (ssum > 0) {
            if (ssum == 1)
                return true;
            if(seen.contains(ssum)) return false;
            seen.add(ssum);
            ssum = sum(ssum);

        }
        return false;
    }

    private int sum(int temp) {
        int res = 0;
        while (temp > 0) {
            int val = (temp % 10);
            res = res + (val * val);
            temp = temp / 10;
        }
        return res;
    }
}
