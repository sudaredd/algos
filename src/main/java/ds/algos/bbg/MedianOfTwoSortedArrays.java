package ds.algos.bbg;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        System.out.println(medianOftwoSortedArraysInLinear(new int[]{1,4,5,6,8}, new int[]{2,3,7,9}));
        System.out.println(medianOftwoSortedArraysInLogN(new int[]{1,4,5,6,8}, new int[]{2,3,7,9}));
    }


    /**
     * refered this video to implement below method
     * https://www.youtube.com/watch?v=LPFhl65R7ww&t=1241s
     *
     * @param first
     * @param second
     * @return
     */
    public static float medianOftwoSortedArraysInLogN(int[] first, int second[]) {
        if(first.length < second.length) {
            return medianOftwoSortedArraysInLogN(second, first);
        }

        int x = first.length;
        int y = second.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partionX = (low + high)/2;
            int partionY = (x +y+1)/2 - partionX;

            int maxLeftX = partionX==0 ? Integer.MIN_VALUE : first[partionX-1];
            int minRightX = partionX==x ? Integer.MAX_VALUE : first[partionX];

            int maxLeftY = partionY == 0 ? Integer.MIN_VALUE : second[partionY-1];
            int minRightY = partionY == y ? Integer.MAX_VALUE : second[partionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x+y)%2==0) {
                    return (float)((Math.max(maxLeftX, maxLeftY)) + Math.min(minRightY, minRightX))/2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                high = partionX-1;
            } else low = partionX+1;
        }
        return -1.0f;
    }

        public static float medianOftwoSortedArraysInLinear(int[] first, int second[]) {
        int res[] = new int[first.length + second.length];

        int pos = 0;
        int left = 0;
        int right = 0;

        while (left < first.length && right < second.length) {
            if (first[left] < second[right]) {
                res[pos++] = first[left++];
            } else {
                res[pos++] = second[right++];
            }
        }

        while (left < first.length) {
            res[pos++] = first[left++];
        }

        while (right < second.length) {
            res[pos++] = second[right++];
        }
        System.out.println("sorted array:" + Arrays.toString(res));
        if (pos % 2 == 1) {
            return res[pos / 2];
        } else {
            int p = pos / 2;
            return (float) (res[p] + res[p - 1]) / 2;
        }
    }
}
