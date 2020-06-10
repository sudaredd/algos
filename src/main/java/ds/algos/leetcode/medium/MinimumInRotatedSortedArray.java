package ds.algos.leetcode.medium;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            else if(nums[low] <=nums[mid] && nums[mid]>nums[high]) {
                low=mid+1;
            }
            else
                high = mid-1;
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumInRotatedSortedArray().findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(new MinimumInRotatedSortedArray().findMin(new int[] {3,4,5,1,2}));
        System.out.println(new MinimumInRotatedSortedArray().findMin(new int[] {3,1,2}));
        System.out.println(new MinimumInRotatedSortedArray().findMin(new int[] {5,1,2,3,4}));
    }
}
