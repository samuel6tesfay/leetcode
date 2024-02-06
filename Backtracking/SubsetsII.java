package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec(0,nums,ans,list);
        return ans;
    }

    public void rec(int start,int[] nums, List<List<Integer>> ans,List<Integer> list){
            ans.add(new ArrayList<>(list));
            for (int i=start;i<nums.length;i++){
                if (i!=start && nums[i]==nums[i-1])continue;
                list.add(nums[i]);
                rec(i+1,nums,ans,list);
                list.remove(list.size() - 1);
            }
    }

}


