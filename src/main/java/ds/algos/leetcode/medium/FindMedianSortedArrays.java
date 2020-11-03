package ds.algos.leetcode.medium;

/**
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] f = {1, 3, 8, 9, 15};
        int[] s = {2, 4, 6, 10, 11};
//        System.out.println(medianOfTwoSortedArrays(f, s));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int nums2[]) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int fLength = nums1.length;


        int sLelngth = nums2.length;

        int low = 0;
        int high = fLength;


        while (low <= high) {

            int fPartition = (low + high) / 2;

            int sPartition = (fLength + sLelngth + 1) / 2 - fPartition;

            int minLeftX = fPartition == 0 ? Integer.MIN_VALUE : nums1[fPartition - 1];
            int maxLeftX = fPartition == fLength ? Integer.MAX_VALUE : nums1[fPartition];

            int minRightY = sPartition == 0 ? Integer.MIN_VALUE : nums2[sPartition - 1];
            int maxRightY = sPartition == sLelngth ? Integer.MAX_VALUE : nums2[sPartition];

            if (minLeftX <= maxRightY && minRightY <= maxLeftX) {
                System.out.println("found a match");
                if ((fLength + sLelngth) % 2 != 0) {
                    return Math.max(minLeftX, minRightY);
                } else {
                    return (double) (Math.max(minLeftX, minRightY) + Math.min(maxLeftX, maxRightY)) / 2;
                }

            } else if (minLeftX > maxRightY) {
                high = fPartition - 1;
            } else {
                low = fPartition + 1;
            }
        }
        return 0;
    }
}
