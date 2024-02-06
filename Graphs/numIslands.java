package leetcode.Graphs;

public class numIslands {

    int n , m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    public void dfs(int i , int j,char[][] grid){
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j]=='0'){
            return;
        }

        grid[i][j] = '0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);

    }

}
