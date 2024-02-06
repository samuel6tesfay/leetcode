package leetcode.Greedy;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int ans = 0;
        int sum = 0;
        for (int i=0;i<cost.length;i++){
            total = total + gas[i] - cost[i];
            sum = sum + gas[i] - cost[i];
            if (total < 0){
                ans = i;
            }
        }

        return sum>=0?ans:-1;
    }

}
