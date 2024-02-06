package leetcode.BinarySearch;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
        System.out.println(searchRotatedSortedArray.search(nums,0));
    }

    public int search(int[] nums, int target) {

        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;

            if (nums[mid]==target)return mid;

            if(nums[mid]>nums[left]){
                if(target>nums[mid] || target<nums[left]){
                    left = mid;
                }else {
                    right = mid;
                }
            }else {
                if(target<nums[mid] || target>nums[right]){
                    right = mid;
                }else {
                    left = mid;
                }
            }

        }
        return -1;
    }
}
