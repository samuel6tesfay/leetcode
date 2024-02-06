package leetcode.Greedy;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int end = nums.length-1;

        for (int i=nums.length-2;i>=0;i++){
            if (nums[i]+i>=end){
                end = nums[i];
            }
        }

        return end==0;
    }

}
