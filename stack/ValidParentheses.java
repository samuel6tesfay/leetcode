package leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        String s = "[]";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> h = new HashMap<>();
        h.put('(',')');
        h.put('{','}');
        h.put('[',']');

        for (int i=0;i<s.length();i++){
            if (h.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if (!stack.isEmpty() && h.get(stack.peek()).equals(s.charAt(i))){
                stack.pop();
            }else {
                return false;
            }
        }


        return stack.isEmpty();
    }
}
