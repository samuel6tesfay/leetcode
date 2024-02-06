package leetcode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
        for (int i=0;i<rooms.length;i++){
            for (int j=0;j<rooms[0].length;j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void wallsAndGates(int[][] rooms) {

        Queue<int[]> queue = new LinkedList<>();

        for (int i=0;i<rooms.length;i++){
            for (int j=0;j<rooms[0].length;j++){
                if (rooms[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int[] dir:dirs){
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if (x>=0 && y>=0 && x < rooms.length && y < rooms[0].length && rooms[x][y]==2147483647){
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{x,y});
                }
            }

        }

    }

}
