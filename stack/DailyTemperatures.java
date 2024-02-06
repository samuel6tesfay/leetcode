package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyT = new DailyTemperatures();
        int[] tempratures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyT.dailyTemperatures(tempratures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.add(i);
        }
        return ans;
    }
}
