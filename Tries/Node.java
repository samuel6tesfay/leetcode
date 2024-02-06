package leetcode.Tries;

public class Node {
    public char value;
    public boolean isWord;
    public Node[] children;

    public int refs = 0;


    public Node(char val) {
        this.value = val;
        this.isWord = false;
        this.children = new Node[26];
    }

    public void addWord(String word,Node node) {
        for (char c : word.toCharArray()) {
            if (!isChareExist(c, node)) {
                node.children[c - 'a'] = new Node(c);
            }
            node.children[c-'a'].refs +=1;
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public void removeWord(String word,Node node) {
        for (char c : word.toCharArray()) {
            node.children[c-'a'].refs -=1;
            node = node.children[c - 'a'];
        }
        node.children[word.charAt(word.length()-1) - 'a'].isWord = false;
    }

    public boolean isChareExist(char c, Node node) {
        for (Node n : node.children) {
            if (n != null && (n.value == c || n.value == '.')) {
                return true;
            }
        }
        return false;
    }

}
