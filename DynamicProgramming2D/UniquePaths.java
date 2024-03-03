package leetcode.DynamicProgramming2D;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] cache=new int[][];
        return dfs(m,n,cache);
    }

    public int dfs(int m,int n,int[][] cache){
        if (n-1==0 || m-1==0){
            return 1;
        }
        if (cache[m][n]!=0){
            return cache[m][n];
        }

        return dfs(m-1,n,cache)+dfs(m,n-1,cache);
    }

}
