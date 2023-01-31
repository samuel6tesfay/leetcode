package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class L26 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,2,2,3,4,4,6,7,7};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates1(nums));


    }

    public static int removeDuplicates(int[] nums) {

        Stack stack = new Stack();
        stack.insertElementAt(nums[nums.length-1],0);
        for (int i = nums.length - 2 ; i >= 0 ; i--){
            if (nums[i] != (int)stack.firstElement()){
                stack.insertElementAt(nums[i],0);
            }
        }
        int stackSize = stack.size();
        for (int i =0 ; i < stackSize;i++){
            nums[i] = (int) stack.elementAt(i);

        }

        return stackSize;

    }

    public static int removeDuplicates1(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
    }

}
