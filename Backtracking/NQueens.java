package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0 ; i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        rec(ans,n,board,0);
        return ans;
    }

    public void rec(List<List<String>> ans,int n,char[][] board,int col){
        if (col==board.length){
            ans.add(changeBoardToList(board));
            return;

        }
        for (int row = 0; row < board.length; row++) {
            if(isBoard(board,row,col)) {
                board[row][col] = 'Q';
                rec(ans, n, board,col+1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> changeBoardToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<board.length;j++){
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public boolean isBoard(char[][] board,int row,int col){
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
}
