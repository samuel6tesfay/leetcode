package leetcode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num:nums){
            if (minHeap.size()<k)minHeap.add(num);
            else{
                if (minHeap.peek()<num){
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        return minHeap.peek();

    }
}
