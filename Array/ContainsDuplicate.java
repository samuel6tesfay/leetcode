package leetcode.Array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums={1,3,2};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> x = new HashSet<>();
        for (int i : nums){
            if(x.contains(i)){
                return true;
            }
            x.add(i);
        }
        return false;
    }
}
