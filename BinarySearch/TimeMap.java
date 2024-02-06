package leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    public static void main(String[] args) {

    }

    HashMap<String, List<Map.Entry<String,Integer>>> map;


    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(Map.entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Map.Entry<String,Integer>> list = map.get(key);
        return search(list, timestamp);
    }
    public String search(List<Map.Entry<String,Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (list.get(mid).getValue() <= timestamp) start = mid; else end =
                    mid - 1;
        }
        if (list.size()==0)return "";
        return list.get(start).getValue() <= timestamp
                ? list.get(start).getKey()
                : "";
    }
}
