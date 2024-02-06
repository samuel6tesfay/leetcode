package leetcode.DynamicProgramming1D;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        if (s.length()<2) return s.length();

        int result = 0,left,right;

        for (int i=0;i<s.length();i++){

            left=i; right=i;
            while (left>0 && right <s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
            left=i; right=i+1;

            while (left>0 && right <s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
        return result;
    }

}
