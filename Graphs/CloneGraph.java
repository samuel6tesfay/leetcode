package leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

    HashMap<Integer, Node> hashMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null)return null;
        if (hashMap.containsKey(node.val))return hashMap.get(node.val);
        Node newNode = new Node(node.val,new ArrayList<Node>());
        hashMap.put(node.val, newNode);
        for (Node neighbor:node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

}
