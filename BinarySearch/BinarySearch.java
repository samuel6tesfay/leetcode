package leetcode.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(b.search(nums,9));
    }
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) i = mid + 1;
            else j = mid - 1;
        }

        return -1;
    }
}
