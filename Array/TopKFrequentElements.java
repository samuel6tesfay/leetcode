package leetcode.Array;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {3,0,1,0};
        System.out.println(Arrays.toString(topKFrequent(nums,1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        List[] freq = new  ArrayList[nums.length+1];

        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        Set<Integer> keys = map.keySet();
        for (int key:keys){
            System.out.println(key);

            if (freq[map.get(key)] == null)
                freq[map.get(key)] = new ArrayList<>();

            freq[map.get(key)].add(key);

        }

        int[] res = new int[k];
        int count = 0;

        for (int i=freq.length-1;i<freq.length;i--){
            if(count==k){
                break;
            }
            if (freq[i]!=null){
                for(Object j:freq[i]){
                    if(count==k){
                        break;
                    }
                    res[count] = Integer.parseInt(j.toString());
                    count++;
                }
            }

        }

        return res;
    }
}

















