package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> parpal = new ArrayList<>();
        rec(0, s, parpal, ans);
        return ans;
    }

    public void rec(int index, String s, List<String> path, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); ++i) {
            if(isPalindrom(s, index, i)) {
                path.add(s.substring(index, i+1));
                rec(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrom(String s,int start, int end){
        while (start<=end){
            if (s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}
