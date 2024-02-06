package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0,candidates,target,new ArrayList<>(),ans);
        return ans;

    }


    public void backTrack(int start,int[] candidates,int target,List<Integer> list,List<List<Integer>> ans){

        if (target==0){
            ans.add(new ArrayList<>(list));
        }

        for (int i=start;i<candidates.length;i++){
            if (i!=start && candidates[i]==candidates[i-1])continue;
            list.add(candidates[i]);
            backTrack(start+1,candidates,target-candidates[i-1],new ArrayList<>(),ans);
            list.remove(list.size() - 1);
        }

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
