package leetcode;

public class L27 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,2,2,3,4,4,6,7,7};
        System.out.println(removeElement(nums,1));
        System.out.println(removeElement1(nums,1));

    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == val) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        for (int i =0; i < nums.length ; i++){
            System.out.println(nums[i]);
        }
        return count;
    }

    public static int removeElement1(int[] nums, int val){
        int count = 0;
        // Loop through all the elements of the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is not val
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
