package leetcode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> rottenOrange = new LinkedList<>();

        int freshOrange = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    rottenOrange.offer(new int[]{i,j});
                } else if (grid[i][j]==1) {
                    freshOrange++;
                }
            }
        }

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int timer = 0;
        while (rottenOrange.isEmpty() && freshOrange !=0){
            int size = rottenOrange.size();
            timer++;
            for (int i=0;i<size;i++){
                int[] r = rottenOrange.poll();
                for (int j=0;j<3;j++){
                    if (r[0]+dir[j][0] >= 0 && r[1]+dir[j][1] >= 0 && r[0]+dir[j][0] < grid.length && r[1]+dir[j][1] < grid[0].length){
                        if (grid[r[0]+dir[j][0]][r[1]+dir[j][1]] == 1){
                            grid[r[0]+dir[j][0]][r[1]+dir[j][1]] = 2;
                            rottenOrange.offer(new int[]{r[0]+dir[j][0],r[1]+dir[j][1]});
                            freshOrange--;
                        }
                    }
                }
            }
        }

        return freshOrange==0?timer:-1;
    }

}
