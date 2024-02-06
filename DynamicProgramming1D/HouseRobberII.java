package leetcode.DynamicProgramming1D;

public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        return Math.max(
                robii(nums, 0, nums.length - 2),
                robii(nums, 1, nums.length - 1)
        );
    }

    public int robii(int[] nums, int start, int end){
        nums[1] = Math.max(nums[start], nums[start+1]);
        for (int i =2 ;i <nums.length;i++){
            nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i]);
        }

        return nums[nums.length-1];
    }

}
