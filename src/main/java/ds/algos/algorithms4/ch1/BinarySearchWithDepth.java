package ds.algos.algorithms4.ch1;

public class BinarySearchWithDepth {

    static int binarySearch(int element, int [] array) {
        return binarySearch(element, array, 0, array.length-1, 0);
    }

    private static int binarySearch(int element, int[] array, int low, int high, int depth) {
        if(low > high)
            return -1;
        System.out.println("low :"+low + " ,high:"+high + " , depth:"+depth);
        int mid = low + (high-low)/2;

        if(element > array[mid]) {
            return binarySearch(element, array, mid+1, high, depth +1);
        } else if(element < array[mid]) {
            return binarySearch(element, array, low, mid-1, depth+1);
        } else return array[mid];
    }
}
