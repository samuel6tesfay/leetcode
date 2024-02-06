package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {




    String digits;
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        Map<Character, String> letters = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        this.digits = digits;
        backTrack(0,new StringBuilder(), ans,letters);
        return ans;
    }

    public void backTrack(int index, StringBuilder sb,List<String> ans,Map<Character, String> letters) {

        if (sb.length() == digits.length()){
            ans.add(sb.toString());
        }else {
                String d = letters.get(digits.charAt(index));
                for (int i=0;i<d.length();i++){
                    sb.append(d.charAt(i));
                    backTrack(index+1,sb,ans,letters);
                    sb.deleteCharAt(sb.length()-1);

            }
        }

    }
}