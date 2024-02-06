package leetcode.DynamicProgramming1D;

public class HouseRobber {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        int temp;
        for (int i =2 ;i <nums.length;i++){
            temp = cur;
            cur = Math.max(temp, pre + nums[i]);
            pre = temp;
        }

        return cur;
    }
}
