package leetcode.DynamicProgramming1D;

public class DecodeWays {

    public int numDecodings(String s) {
        return numDecodings(s, 0, new Integer[s.length()]);
    }

    private int numDecodings(String s, int i, Integer[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != null) return dp[i];
        int count = 0;
        count += numDecodings(s, i + 1, dp);
        if (
                i < s.length() - 1 &&
                        (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')
        ) {
            count += numDecodings(s, i + 2, dp);
        }
        dp[i] = count;
        return dp[i];
    }

}
