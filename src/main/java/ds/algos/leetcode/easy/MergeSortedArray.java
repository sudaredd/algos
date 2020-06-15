package ds.algos.leetcode.easy;

import java.util.Arrays;

/**
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int num1[] = new int[]{1,2,3,0,0,0};
        new MergeSortedArray().merge(num1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(num1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m+n-1;
        int firstTail = m-1;
        int secondtail = n-1;
        while (firstTail >=0 && secondtail >=0) {
            nums1[pos--] = nums1[firstTail] > nums2[secondtail] ? nums1[firstTail--] : nums2[secondtail--];
        }
        while (secondtail >=0) {
            nums1[pos--] = nums2[secondtail--];
        }
    }
    public void mergeWithNewArray(int[] nums1, int m, int[] nums2, int n) {
        int res[] = new int[m+n];
        int pos = 0;
        int first = 0;
        int second = 0;
        while (first <m && second <n) {
            if(nums1[first]==nums2[second]) {
                res[pos++] = nums1[first++];
                res[pos++] = nums2[second++];
            } else  if(nums1[first] < nums2[second]) {
                res[pos++] = nums1[first++];
            } else {
                res[pos++] = nums2[second++];
            }
        }
        while (first <m) {
            res[pos++] = nums1[first++];
        }
        while (second <n) {
            res[pos++] = nums2[second++];
        }
        for(int i=0; i<res.length; i++) {
            nums1[i] = res[i];
        }
    }
}
