package leetcode.Greedy;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int curSum = 0;
        int maxSum = nums[0];

        for(int num:nums){
            curSum = Math.max(curSum,0);
            curSum += num;
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }

}
