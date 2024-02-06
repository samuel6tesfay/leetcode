package leetcode.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        String s = "eaaaabaaec";
        System.out.println(partitionLabels(s));
    }


    public static List<Integer> partitionLabels(String s) {

        HashMap<Character,Integer> hashMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (Character c:s.toCharArray()){
            hashMap.put(c,s.lastIndexOf(c));
        }


        int lastIndex = 0;
        for (int i=0;i<s.length();i++){

            int end = hashMap.get(s.charAt(i))+1;
            for (int j=0;j<end-1;j++){
                end = Math.max(end,hashMap.get(s.charAt(j))+1);
            }
            if(end==s.length()-1){
                ans.add(end-lastIndex+1);
            }else{
                ans.add(end-lastIndex);
            }
            lastIndex += ans.get(ans.size()-1);
        }

        return ans;
    }
}
