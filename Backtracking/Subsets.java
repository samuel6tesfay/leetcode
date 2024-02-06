package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec(0,nums,ans,list);
        return ans;
    }

    public void rec(int start,int[] nums, List<List<Integer>> ans,List<Integer> list){

        if (start >= nums.length){
            ans.add(new ArrayList<>(list));
        }else{
            list.add(nums[start]);
            rec(start+1,nums,ans,list);
            list.remove(list.size() - 1);
            rec(start+1,nums,ans,list);
        }

    }

}
