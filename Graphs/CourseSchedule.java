package leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i< prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            if (visited[i] == 0) {
                if(isCycle(adj,visited,i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCycle(List<List<Integer>> adj,int[] visited,int i){
        if (visited[i] == 2) {
            return true;
        }

        visited[i] = 2;
        for (int j=0;j<adj.get(i).size();j++){
            if (visited[adj.get(i).get(j)] != 1) {
                if (isCycle(adj,visited,adj.get(i).get(j))){
                    return true;
                }
            }

        }
        visited[i] = 1;
        return false;
    }

}
