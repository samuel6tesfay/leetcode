package leetcode.Array;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
         int[] nums = {1,2,3,4};
         System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] sufix = new int[nums.length];

        int[] output = new int[nums.length];

        int i = 0;
        int j = nums.length-1;

        prefix[i] = nums[i];
        sufix[j] = nums[j];

        while (i<nums.length-1){
            i++;
            j--;
            prefix[i] = nums[i] * prefix[i-1];
            sufix[j] = nums[j] * sufix[j+1];
        }

        output[0] = sufix[1];
        output[output.length-1] = prefix[output.length-2];
        for (int k = 1 ; k < output.length-1 ; k++){
            output[k] = prefix[k-1] * sufix[k+1];
        }

        return output;
    }
}
