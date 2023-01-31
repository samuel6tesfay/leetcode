package leetcode;

import static java.lang.Long.reverse;

public class L9 {

    public static void main(String[] args) {
        System.out.println( isPalindrome(121));
        System.out.println(isPalindrome1(1211214));
    }


    public static boolean isPalindrome(int x) {

            StringBuilder str = new StringBuilder(String.valueOf(x));
            String string2 = str.toString();
            String string1 = str.reverse().toString();
            if (string2.equals(string1)){
                return true;
            }
            return false;

    }

    public static boolean isPalindrome1(int x) {

        int num = x;
        int pal = 0;

        while (num > 0){
            pal = pal * 10 + num % 10;
            num = num / 10;
        }
        if(x == pal){
            return true;
        }
        return false;

    }
}
