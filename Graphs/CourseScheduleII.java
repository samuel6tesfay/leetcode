package leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII {

    static int count = 0;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        count = numCourses-1;
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int[] l = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i< prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            if (visited[i] == 0) {
                if(isCycle(adj,visited,i,l)){
                    return new int[0];
                }
            }
        }
        return l;
    }

    public static boolean isCycle(List<List<Integer>> adj,int[] visited,int i , int[] l){
        if (visited[i] == 2) {
            return true;
        }
        visited[i] = 2;
        for (int j=0;j<adj.get(i).size();j++){
            if (visited[adj.get(i).get(j)] != 1) {
                if (isCycle(adj,visited,adj.get(i).get(j),l)){
                    return true;
                }
            }

        }
        l[count] = i;
        count--;
        visited[i] = 1;
        return false;
    }
}
