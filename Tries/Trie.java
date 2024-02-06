package leetcode.Tries;

public class Trie {

    public Node[] root;
    public Trie() {
        root = new Node[26];
    }

    public void insert(String word) {
        Node[] node = root;
        for (char c:word.toCharArray()){
            if (!isChareExist(c,node)){
                node[c-'a'] = new Node(c);
            }
            node = node[c-'a'].children;
        }
        node[word.charAt(word.length()-1)-'a'].isWord = true;

    }

    public boolean search(String word) {
        Node[] node = root;
        for (char c:word.toCharArray()){
            if (!isChareExist(c,node)){
                return false;
            }
            node = node[c-'a'].children;
        }

        return node[word.charAt(word.length()-1)-'a'].isWord;
    }

    public boolean startsWith(String prefix) {
        Node[] node = root;
        for (char c:prefix.toCharArray()){
            if (!isChareExist(c,node)){
                return false;
            }
            node = node[c-'a'].children;
        }

        return true;
    }

    public boolean isChareExist(char c,Node[] node){
        for (Node n:node){
            if (n != null && n.value==c){
                return true;
            }
        }
        return false;
    }


}
