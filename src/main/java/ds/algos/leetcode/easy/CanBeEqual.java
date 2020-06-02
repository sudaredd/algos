package ds.algos.leetcode.easy;

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target == null || arr == null || target.length != arr.length)
            return false;
        int res[] = new int[1001];
        for (int i = 0; i < target.length; i++) {
            res[target[i]]++;
            res[arr[i]]--;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0)
                return false;
        }
        return true;
    }
}
