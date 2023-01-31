package leetcode;

public class L1544 {

    public static void main(String[] args){
        makeGood("abBAcC");
    }

    public static String makeGood(String s) {

        for (int i = 0; i < s.length()-1; i++) {
            if((int)s.charAt(i) == (int)s.charAt(i+1)+32 || (int)s.charAt(i) == (int)s.charAt(i+1)-32){
                s = s.substring(0, i) + s.substring(i+2);
                return  makeGood(s);
            }
        }
        return s;
    }
}
