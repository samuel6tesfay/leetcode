package leetcode.AdvancedGraphs;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[] {0,0});
        int cost = 0;
        while (visited.size()<points.length){
            int[] currentValue = minHeap.poll();
            int weight = currentValue[0];
            int currentNode = currentValue[1];

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);
            cost += weight;

            for (int i=0;i<points.length;i++){
                if (!visited.contains(i)){
                    weight = Math.abs(points[i][0]-points[currentNode][0]) + Math.abs(points[i][1]-points[currentNode][1]);
                    minHeap.add(new int[] {weight,i});
                }
            }

        }
        return cost;
    }

}
