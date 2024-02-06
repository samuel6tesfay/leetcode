package leetcode.HeapPriorityQueue;

import java.util.PriorityQueue;

public class KClosestPointsOrigin {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->
                Integer.compare(
                        (a[0] * a[0] + a[1] * a[1]),
                        (b[0] * b[0] + b[1] * b[1])
                )
        );

        for (int[] point:points)q.offer(point);

        int[][] ans = new  int[k][2];

        for (int i=0;i<k;i++){
            int[] p = q.poll();
            ans[i][0] = p[0];
            ans[i][1] = p[1];
        }

        return ans;

    }
}
