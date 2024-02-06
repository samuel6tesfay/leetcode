package leetcode.Graphs;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i=0;i<n;i++){
            dfs(0,i,board);
            dfs(m-1,i,board);
        }

        for (int i=0;i<m;i++){
            dfs(i,0,board);
            dfs(i,n-1,board);
        }

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                } else if (board[i][j]=='1') {
                    board[i][j]='O';

                }
            }
        }
    }

    public void dfs(int m,int n,char[][] board){
        if (m<0||n<0||m>=board.length||n>=board[0].length)return;
        if (board[m][n] != 'O')return;

        board[m][n]='1';

        dfs(m+1,n,board);
        dfs(m-1,n,board);
        dfs(m,n+1,board);
        dfs(m,n-1,board);



    }

}
