package leetcode.Tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII{


    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        String[] words = {"ab","cd","fg"};
        char[][] board = {{'a','b'},{'c','f'}};
        wordSearchII.findWords(board,words);
    }

    private static int COLS;
    private static int ROWS;
    public static Node[] root;

    public WordSearchII(){
        root = new Node[26];

    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            Node.addWord(word);
        }


        ROWS = board.length;
        COLS = board[0].length;
        HashSet<String> visit = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, board,"",res,visit,root);
            }
        }
        return new ArrayList<>(res);
    }

    public static void dfs(int r, int c, char[][] board,String word,HashSet<String> res,HashSet<String> visit,Node[] node) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS
                || visit.contains(r + "-" + c )
                || node[board[r][c] - 'a'] == null
                || node[board[r][c] - 'a'].refs < 1
               ) {
            return;
        }
        visit.add(r + "-" + c);
        word += board[r][c];
        if (node[board[r][c]-'a'].isWord) {
            node[board[r][c]-'a'].isWord = false;
            System.out.println(word);
            res.add(word);
            Node.removeWord(word);
        }

        dfs(r + 1, c , board,word,res,visit,node[board[r][c]-'a'].children);
        dfs(r - 1, c,board,word,res,visit,node[board[r][c]-'a'].children);
        dfs(r, c + 1, board,word,res,visit,node[board[r][c]-'a'].children);
        dfs(r, c - 1, board,word,res,visit,node[board[r][c]-'a'].children);
        visit.remove(r + "-" + c);

    }

    public static class Node {
        public char value;
        public boolean isWord;
        public Node[] children;

        public int refs;


        public Node(char val) {
            this.value = val;
            this.isWord = false;
            this.children = new Node[26];
            this.refs = 0;
        }

        public static void addWord(String word) {
            Node[] node = root;
            int count = 0;
            for (char c:word.toCharArray()){
                count++;
                if (!isChareExist(c,node)){
                    node[c-'a'] = new Node(c);
                }
                if(word.length()==count){
                    node[c-'a'].isWord = true;
                }
                node[c-'a'].refs +=1;
                node = node[c-'a'].children;
            }

        }

        public static void removeWord(String word) {
            Node[] node = root;
            int count = 0;
            for (char c:word.toCharArray()){
                count++;
                if(word.length()==count){
                    node[c-'a'].isWord = false;
                }
                node[c-'a'].refs -=1;
                node = node[c-'a'].children;
            }
        }

        public static boolean isChareExist(char c, Node[] node){
            for (Node n:node){
                if (n != null && n.value==c){
                    return true;
                }
            }
            return false;
        }

    }


}
