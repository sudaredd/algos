package ds.algos.bbg;

/**
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeros {

    public void moveZeros(int[] arr) {

        int pos = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                arr[pos++] = arr[j];
            }
        }
        for (; pos < arr.length; pos++) {
            arr[pos] = 0;
        }
    }
}
