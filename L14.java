package leetcode;

public class L14 {

    public static void main(String[] args) {


        String[] strs = {"ab","abc"};
        System.out.println((longestCommonPrefix(strs)));
        System.out.println((longestCommonPrefix2(strs)));

    }



    public static String longestCommonPrefix(String[] strs) {

        String commonPrefix = "";
        commonPrefix = strs[0];

        for (int i = 1 ; i < strs.length ; i++){
            if (commonPrefix == ""){
                return commonPrefix;
            }else {
                String com = "";
                for (int j=0;j < commonPrefix.length();j++){
                    if(strs[i].startsWith(commonPrefix.substring(0,j+1))){
                        com = commonPrefix.substring(0,j+1);
                    }
                }
                commonPrefix = com;
            }
        }

        return commonPrefix;
    }

    public static String longestCommonPrefix2(String[] strs){

        StringBuilder longestCommonPrefix = new StringBuilder();

        if (strs==null || strs.length == 0){
            return longestCommonPrefix.toString();
        }
        int minString = strs[0].length();
        for (int i = 1;i<strs.length;i++){
            minString = Math.min(minString,strs[i].length());
        }

        for (int i = 0;i<minString;i++){

            char current = strs[0].charAt(i);
            for (String str:strs){
                if (str.charAt(i) != current) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(current);

        }
        return longestCommonPrefix.toString();

    }

}
