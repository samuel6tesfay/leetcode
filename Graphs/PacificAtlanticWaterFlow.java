package leetcode.Graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {{1,2,3},{8,9,4},{7,6,5}};
        pacificAtlantic(heights);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacficOcian = new boolean[heights.length][heights[0].length];

        boolean[][] atlanticOcian = new boolean[heights.length][heights[0].length];

        List<List<Integer>> ans = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        for (int i=0,j=m-1;i<m;i++,j--){
            dfs(0,i,heights,pacficOcian,Integer.MIN_VALUE);
            dfs(m-1,j,heights,atlanticOcian,Integer.MIN_VALUE);

        }

        for (int i=0,j=n-1;i<n;i++,j--){
            dfs(i,0,heights,pacficOcian,Integer.MIN_VALUE);
            dfs(j,n-1,heights,atlanticOcian,Integer.MIN_VALUE);

        }


        for (int i=0;i<heights.length;i++){
            for (int j=0;j<heights[0].length;j++){
                if (pacficOcian[i][j]&&atlanticOcian[i][j]){
                    ans.add(List.of(i,j));
                }
            }
        }


        return ans;
    }


    public static void dfs(int m, int n, int[][] heights, boolean[][] ocean,int prev){
        if (m<0||n<0||m>=heights.length||n>=heights[0].length)return;
        if (heights[m][n] < prev || ocean[n][n]) return;

        ocean[m][n] = true;
        dfs(m-1,n,heights,ocean,heights[m][n]);
        dfs(m+1,n,heights,ocean,heights[m][n]);
        dfs(m,n-1,heights,ocean,heights[m][n]);
        dfs(m,n+1,heights,ocean,heights[m][n]);


    }
}
