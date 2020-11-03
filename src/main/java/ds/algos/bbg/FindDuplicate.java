package ds.algos.bbg;

/**
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicate(new int[]{3, 1, 3, 4, 2}));

        System.out.println(new FindDuplicate().findDuplicate_practice(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicate_practice(new int[]{3, 1, 3, 4, 2}));
    }

    /**
     * Floyd detection algorithm
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {


        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public int findDuplicate_practice(int[] nums) {

        int fast = nums[0];
        int slow = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast)
                break;
        }
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
