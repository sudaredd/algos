package ds.algos.amazon;

public class FindMedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int fLength = nums1.length;
        int sLength = nums2.length;
        int left = 0;
        int right = fLength;

        while (left <= right) {
            int fPartition = (left + right) / 2;
            int sPartition = (fLength + sLength + 1) / 2 - fPartition;

            int minLeftX = fPartition == 0 ? Integer.MIN_VALUE : nums1[fPartition - 1];
            int maxLeftX = fPartition == fLength ? Integer.MAX_VALUE : nums1[fPartition];

            int minRightY = sPartition == 0 ? Integer.MIN_VALUE : nums2[sPartition - 1];
            int maxRightY = sPartition == sLength ? Integer.MAX_VALUE : nums2[sPartition];

            if (minLeftX <= maxRightY && minRightY <= maxLeftX) {
                System.out.println("found a match");
                if ((fLength + sLength) % 2 == 0) {
                    return (double) (Math.max(minLeftX, minRightY) + Math.min(maxLeftX, maxRightY)) / 2;
                } else
                    return Math.max(minLeftX, minRightY);
            } else if (minLeftX > maxRightY) {
                right = fPartition - 1;
            } else
                left = fPartition + 1;
        }
        return 0;
    }
}
