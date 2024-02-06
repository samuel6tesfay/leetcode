package leetcode.Greedy;

public class MergeTripletstoFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
          boolean[] gr = new boolean[3];

          loop:for (int[] triple:triplets){

              for (int i=0;i<3;i++){
                  if (triple[i] > target[i]){
                      continue loop;
                  }
              }
              for (int i=0;i<3;i++){
                  if (triple[i] == target[i]){
                      gr[i] = true;
                  }
              }


          }

        return gr[0]&&gr[1]&&gr[2];
    }

}
