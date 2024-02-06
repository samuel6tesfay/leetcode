package leetcode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int stone:stones)maxHeap.offer(-stone);

        while (maxHeap.size()>1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 != stone2) maxHeap.add(stone1 - stone2);

        }
        return maxHeap.size() != 0 ? (-maxHeap.remove()) : 0;

    }
}
