package leetcode.stack;
import java.util.Map;
import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleHistogram.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {

        int area = 0, n = heights.length;
        int start;
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int curHt =heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > curHt){
                Map.Entry<Integer, Integer> pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(Map.entry(start,curHt));
        }

        while(!stack.isEmpty()){
            Map.Entry<Integer, Integer> pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            area = Math.max(area, h * (n - index));
        }
        return area;
    }
}