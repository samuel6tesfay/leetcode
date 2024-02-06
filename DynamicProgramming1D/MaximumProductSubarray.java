package leetcode.DynamicProgramming1D;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        int min=1;
        int max=1;
        for (int i=0;i<nums.length;i++){
            int temp = max*nums[i];
            max = Math.max(nums[i],Math.max(min*nums[i],temp));
            min = Math.min(nums[i],Math.min(min*nums[i],temp));
            res = Math.max(res, max);
        }
        return res;
    }


}
