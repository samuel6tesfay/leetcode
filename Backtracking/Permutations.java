package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recursion(nums,freq,new ArrayList<>(),ans);
        return ans;
    }

    public void recursion(int[] nums,boolean[] freq,List<Integer> list,List<List<Integer>> ans){
        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list));
        }

        for (int i =  0; i<nums.length;i++){
            if (!freq[i]){
                freq[i] = true;
                list.add(nums[i]);
                recursion(nums,freq,list,ans);
                list.remove(list.size()-1);
                freq[i] = false;

            }
        }

    }

}
