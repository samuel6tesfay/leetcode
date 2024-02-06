package leetcode.BinarySearch;

public class FindMinimumRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        FindMinimumRotatedSortedArray findMinimumRotatedSortedArray = new FindMinimumRotatedSortedArray();
        System.out.println(findMinimumRotatedSortedArray.findMin(nums));
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return 0;
    }
}

