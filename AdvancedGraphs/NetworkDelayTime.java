package leetcode.AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] c = new int[n];
        Arrays.fill(c, -1);
        c[k-1] = 0;
        int ans = -1;
        for (int i=0;i<n;i++){
            for (int j=0;j<times.length;j++){
                if (c[times[j][0] - 1] != -1 && c[times[j][0] - 1] + times[j][2] < c[times[j][1] - 1]) {
                    c[times[j][1] - 1] = c[times[j][0] - 1] + times[j][2];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (c[i] == -1) {
                return -1;
            }
            ans = Math.max(ans, c[i]);
        }

        return ans;
    }

}
