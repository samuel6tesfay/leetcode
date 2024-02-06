package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    public void backTrack(int start,int[] candidates,int target,List<Integer> list,List<List<Integer>> ans){

        if (target>=0){
            if (target==0){
                ans.add(new ArrayList<>(list));
            }
        }
        else {
            list.add(candidates[start]);
            backTrack(start+1,candidates,target,new ArrayList<>(),ans);
            list.remove(list.size()-1);
            backTrack(start+1,candidates,target,new ArrayList<>(),ans);
        }

    }
}
