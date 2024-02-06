package leetcode.twopointers;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[]  numbers = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers,9)));

    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while (right>left){
            if(numbers[left]+numbers[right] > target){
                right--;
                continue;
            }

            if(numbers[left]+numbers[right] < target){
                left++;
                continue;
            }

            if ((numbers[left]+numbers[right] == target)){
                return new int[] {left+1 , right+1};
            }
        }
        return new int[] {};


    }
}
