package leetcode.SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement(s,1));
    }
    public int characterReplacement(String s, int k) {

        int[] alph = new int[26];
        int sol=0,i=0,max = 0;

        for (int j=0;j<s.length();j++){
            int currentValue= s.charAt(j) - 'A';
            alph[currentValue]++;
            max = Math.max(max,alph[currentValue]);
            if(j - i + 1 - max > k){
                alph[s.charAt(i) - 'A']--;
                i++;

            }

            sol = Math.max(sol,j - i+1);
        }

        return sol;
    }
}
