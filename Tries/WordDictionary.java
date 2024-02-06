package leetcode.Tries;

class WordDictionary {

    public Node[] root;

    public WordDictionary() {
        root = new Node[26];

    }

    public void addWord(String word) {
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
            node = node[c-'a'].children;
        }

    }

    public boolean search(String word) {
        Node[] node = root;
        int count = 0;
        for (char c:word.toCharArray()){
            count++;
            if (!isChareExist(c,node)){
                return false;
            }
            if(word.length()!=count){
                node = node[c-'a'].children;
            }
        }
        return node[word.charAt(word.length()-1)-'a'].isWord;
    }
    public boolean isChareExist(char c,Node[] node){
        for (Node n:node){
            if (n != null && (n.value==c || n.value=='.')){
                return true;
            }
        }
        return false;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
