package leetcode.Array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {

        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        for (int i=0;i<9;i++){
            rowSet = new HashSet<>();
            colSet = new HashSet<>();

            for (int j=0;j<9;j++){
                char r = board[i][j];
                char c = board[j][i];

                if (r != '.'){
                    if (rowSet.contains(r)){
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }

                if(c != '.'){
                    if (colSet.contains(c)){
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }

        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                //checkBlock will return true if valid
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }


        return true;
    }

    public boolean checkBlock(int idxI, int idxJ, char[][] board) {

        Set<Character> s = new HashSet<>();;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board[i+idxI][j+idxJ] != '.'){
                    if(s.contains(board[i+idxI][j+idxJ])){
                        return false;
                    }
                    s.add(board[i+idxI][j+idxJ]);
                }
            }
        }
        return true;
    }

    }
