package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20_Valid_Parentheses {

    public static void main(String[] args) {
        System.out.println(isValid1("))"));
    }

    public static boolean isValid(String s) {

        Map<Character,Character> romanMap = new HashMap<>();
        romanMap.put('(', ')');
        romanMap.put('[', ']');
        romanMap.put('{', '}');

        if (s.length() % 2 != 0){
            return false;
        }
        int len = s.length() / 2 ;
        System.out.println(len);
        for (int i=1;i<=len;i++){
            if(romanMap.get(s.charAt(len - i )) != s.charAt(len + i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValid1(String s){

        Map<Character,Character> romanMap = new HashMap<>();
        romanMap.put('(', ')');
        romanMap.put('[', ']');
        romanMap.put('{', '}');


        if (s.length() % 2 != 0){
            return false;
        }

        Stack<Character> leftSymbols = new Stack<>();

        for (char c : s.toCharArray()){

            if(!"([{}])".contains(c+"")){
                System.out.println("x");
                return false;
            }

            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.push(c);
            } else if (leftSymbols.size() > 0) {
                if(c == ')' && leftSymbols.lastElement() == '(' || c == ']' && leftSymbols.lastElement() == '[' || c == '}' && leftSymbols.lastElement() == '{'){
                    leftSymbols.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }

        if(leftSymbols.size() > 0){
            return false;
        }
        return true;

    }

    public static boolean isValid2(String s){
        Stack<Character> leftSymbols = new Stack<>();
        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // If left symbol is encountered
            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.push(c);
            }
            // If right symbol is encountered
            else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
                leftSymbols.pop();
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
                leftSymbols.pop();
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
                leftSymbols.pop();
            }
            // If none of the valid symbols is encountered
            else {
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }

}
