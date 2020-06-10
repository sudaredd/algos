package ds.algos.sort;

import java.util.Arrays;

/**
 * implemented by based on this video
 * https://www.youtube.com/watch?v=QN9hnmAgmOc
 */
public class QuickSort {

    public static void main(String[] args) {
        int items[] = {7, 6, 10, 5, 9, 2, 1, 15, 7};
        System.out.println("before sort:"+Arrays.toString(items));

        new QuickSort().quickSort(items, 0, items.length-1);
        System.out.println("After sort:"+Arrays.toString(items));
    }
    public void quickSort(int items[], int lb, int ub) {
        if (lb < ub)
        {
            int res = partition(items, lb, ub);
            quickSort(items, lb, res-1);
            quickSort(items, res+1, ub);
        }
    }

    private int partition(int[] items, int lb, int ub) {
        int pivot = items[lb];
        int start = lb;
        int end = ub;
        while (start < end) {
            while (start < items.length && items[start] <= pivot)
                start++;
            while (end < items.length && items[end] > pivot)
                end--;
            if(start < end)
                swap(items, start, end);
        }
        swap(items, lb, end);
        return end;
    }

    public void swap(int []items, int start, int end) {
        int temp = items[start];
        items[start]= items[end];
        items[end] = temp;
    }
}
