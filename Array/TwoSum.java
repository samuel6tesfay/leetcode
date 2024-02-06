package leetcode.Array;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums,6)));
    }

    public static int[] twoSum(int[] nums, int target) {

            HashMap<Integer,Integer> cNums = new HashMap<>();

            for (int i=0;i<nums.length;i++){
                int diff = target - nums[i];

                if(cNums.containsKey(diff)){
                    return new int[] {i,cNums.get(diff)};
                }

                cNums.put(nums[i],i);
            }

            return new int[] {};
    }
}
