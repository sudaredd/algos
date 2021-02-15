package ds.algos.bbg_practice;

public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicate(new int[]{3, 1, 3, 4, 2}));

        System.out.println(new FindDuplicate().findDuplicateWithXor(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicateWithXor(new int[]{3, 1, 3, 4, 2}));
    }

    private int findDuplicateWithXor(int nums[]) {
        int xor = 0;

        for (int i : nums) {
            xor = xor ^ i;
        }
        int length = nums.length - 1;
        for (int i = 1; i <= length; i++) {
            xor = xor ^ i;
        }
        return xor;
    }

    private int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
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
