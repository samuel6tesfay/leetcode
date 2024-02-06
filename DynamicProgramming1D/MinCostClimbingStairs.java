package leetcode.DynamicProgramming1D;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int cur=0,prev=0;

        for (int i=cost.length-1;i>=0;i--){
            cost[i] += Math.min(cur,prev);
            prev = cur;
            cur = cost[i];
        }

        return Math.min(cost[0],cost[1]);

    }

}
