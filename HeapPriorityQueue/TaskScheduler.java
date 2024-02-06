package leetcode.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();

        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;
        for (int val : arr) if (val > 0) heap.add(val);
        int time = 0;

        while ((!heap.isEmpty() || !q.isEmpty())) {
            time++;
            if (!heap.isEmpty()) {
                int val = heap.poll();
                val--;
                if (val > 0) q.add(Map.entry(val, time + n));
            }
            if (!q.isEmpty() && q.peek().getValue() == time) heap.add(
                    q.poll().getKey()
            );
        }

        return time;
    }
}
