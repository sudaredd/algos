package ds.algos;

import java.util.Arrays;

public class FindMinDiff {

    public static int findMinDiff(int arr[]) {

        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {

            if (diff > arr[i + 1] - arr[i]) {

                diff = arr[i + 1] - arr[i];

            }
        }

        return diff;

    }
}
