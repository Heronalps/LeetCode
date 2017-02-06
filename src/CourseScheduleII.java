import java.util.*;

/**
 * Created by michaelzhang on 2/5/17.
 */
public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites){
        //Sanity Check to do
        if (numCourses == 0) {
            return new int[]{};
        }
        int[] result = new int[numCourses];
// Mapping node to indegree
        Map<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        // Initiate indegree
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            neighbors.put(i, new ArrayList<>());
        }
        for (int row = 0; row < prerequisites.length; row++) {
            neighbors.get(prerequisites[row][1]).add(prerequisites[row][0]);
            indegree.put(prerequisites[row][0],
                    indegree.get(prerequisites[row][0]) + 1);
        }
//BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }
        int nextIndex = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            result[nextIndex] = current;
            nextIndex++;
            ArrayList<Integer> list = neighbors.get(current);
            for (int neighbor : list) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (nextIndex == numCourses) {
            return result;
        }
        return new int[]{};
    }



    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        for (int i : findOrder(2,prerequisites))
            System.out.println(i);
    }
}
