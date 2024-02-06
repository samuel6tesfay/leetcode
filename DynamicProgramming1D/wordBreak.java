package leetcode.DynamicProgramming1D;

import java.util.List;

public class wordBreak {

    public boolean wordBreak(String word, List<String> dict){
        boolean T[][] = new boolean[word.length()][word.length()];
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                if(dict.contains(str)){
                    T[i][j] = true;
                    continue;
                }
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] && T[k][j]){
                        T[i][j] = true;
                        break;
                    }
                }
            }
        }
        return T[0][word.length()-1];
    }
}

