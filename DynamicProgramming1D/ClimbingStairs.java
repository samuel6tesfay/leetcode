package leetcode.DynamicProgramming1D;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] x = new int[n+1];
        Arrays.fill(x,-1);
        return rec(n,x);
    }

    public int rec(int n,int[] memo) {
        if (n==0 || n==1){
            memo[n] = 1;
            return 1;
        }
        if (memo[n] != -1) return memo[n];

        memo[n] = rec(n-1,memo) + rec(n-2,memo);
        return memo[n];
    }
}
