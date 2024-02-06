package leetcode.linkedlist;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {2,7,5,6,5,3,8,9,7,1};
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
        System.out.println(findDuplicateNumber.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        while (slow != fast);

        int slow2 = 0;

        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        while (slow != slow2);

        return slow2;

    }

}
