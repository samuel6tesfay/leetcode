package leetcode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num:nums)add(num);
    }

    public int add(int val) {

        if (heap.size()<k)heap.offer(val);
        else if (val>heap.peek()){
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
