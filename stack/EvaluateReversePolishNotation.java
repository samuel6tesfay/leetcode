package leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {

        Stack<Integer>  stack = new Stack<>();

        for (String token:tokens){
            if (token.equals("+")){
                stack.add(stack.pop()+stack.pop());
            } else if (token.equals("*")) {
                stack.add(stack.pop()*stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop() , b = stack.pop();
                stack.add(b-a);
            } else if (token.equals("/")) {
                int a = stack.pop() , b = stack.pop();
                stack.add(b/a);
            }else {
                stack.add(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
