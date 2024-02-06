package leetcode.Greedy;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> op = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') op.push(i);
            else if (s.charAt(i) == ')') {
                if (op.size() > 0) op.pop();
                else if (st.size() > 0) st.pop();
                else return false;
            } else st.push(i);
        }


        while (op.size() > 0 && st.size() > 0) {
            if (op.peek() > st.peek()) return false;
            op.pop();
            st.pop();
        }

        return op.size() == 0;
    }
}
