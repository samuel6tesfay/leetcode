package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){

        Arrays.sort(nums);
        List<List<Integer>>  x = new ArrayList<>();

        for (int i=0;i<nums.length;i++){

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i+1;
            int  right = nums.length-1;
            while (left<right){
                if (nums[left] + nums[right] + nums[i] < 0){
                    left++;
                } else if(nums[left]+nums[right]+nums[i] == 0){
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[left]);a.add(nums[right]);a.add(nums[i]);
                    x.add(a);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else {
                    right--;

                }
            }
        }
        return x;

    }


}
