package leetcode.AdvancedGraphs;

import java.util.PriorityQueue;

public class SwiminRisingWater {
    public int swimInWater(int[][] grid) {

        PriorityQueue<int[]> meanHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visit = new boolean[grid.length][grid.length];

        meanHeap.add(new int[] {grid[0][0],0,0});

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int ans = grid[0][0];

        while (!meanHeap.isEmpty()){
            int[] gr = meanHeap.poll();
            if (gr[1] == grid.length - 1 && gr[2] == grid.length - 1) {
                ans = Math.max(ans, gr[0]);
                break;
            }

            for (int i=0;i<4;i++){
                int x = gr[1] + dirs[i][0];
                int y = gr[2] + dirs[i][1];

                if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || visit[x][y]) {
                    continue;
                }
                meanHeap.add(new int[] {Math.max(gr[0],grid[x][y]),x,y});
                visit[x][y] = true;
            }


        }

        return ans;

    }
}
