package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {

    public static void main(String[] args) {
        List<String> strs =new ArrayList<>();
        strs.add("we");
        strs.add("say");
        strs.add(":");
        strs.add("yes");

        System.out.println(decode(encode(strs)));

        System.out.println(strs);
    }

    public static String encode(List<String> strs) {

        String est = "";
        for (int i=0;i<strs.size();i++){
            est = est+strs.get(i).length()+strs.get(i);
        }
        return est;
    }

    public static List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        for (int i=1;i<str.length();){
            int strSize = str.charAt(i-1)-'0';
            strs.add(str.substring(i,i+strSize));
            i = i + 1+strSize;
        }
        return strs;
    }
}
