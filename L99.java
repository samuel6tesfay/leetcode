package leetcode;

public class L99 {

    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public static boolean isPalindrome(int x) {

        StringBuilder str = new StringBuilder(x);
        str.reverse();

        System.out.println(str.reverse());

        return true;

    }
}
