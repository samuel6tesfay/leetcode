package leetcode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer>  smallNums;
    PriorityQueue<Integer>  largeNums;

    public  MedianFinder() {
        smallNums = new PriorityQueue<>((a,b)->b-a);
        largeNums = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallNums.add(num);

        if (smallNums.size()>largeNums.size()){
            largeNums.add(smallNums.poll());
        }else if(smallNums.peek() > largeNums.peek()){
            int n = smallNums.poll();
            smallNums.add(largeNums.poll());
            largeNums.add(n);
        }
    }

    public double findMedian() {
        if (largeNums.size()>smallNums.size()){
            return largeNums.peek();
        }else {
            return ((double) largeNums.peek()+(double)smallNums.peek())/2;
        }
    }

}
