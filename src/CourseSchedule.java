import java.util.HashSet;

/**
 * Created by michaelzhang on 1/31/17.
 */

// The idea is correct, but it will have stackoverflow error when test case is really big, like over a hundred courses.
public class CourseSchedule {
    private static HashSet<Integer> visited = null;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        UndirectedGraphNode[] graph = new UndirectedGraphNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            UndirectedGraphNode node = new UndirectedGraphNode(i);
            graph[i] = node;
        }
        for (int row = 0; row < prerequisites.length; row++) {
            int courseID = prerequisites[row][0];
            int prereqID = prerequisites[row][1];
            graph[courseID].neighbors.add(graph[prereqID]);
        }

        for (UndirectedGraphNode node : graph) {
            visited = new HashSet<>();
            if(hasCycle(graph, node.label, visited)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasCycle(UndirectedGraphNode[] graph, int index, HashSet<Integer> visited) {
        //Base case to do
        if (graph[index].neighbors.size() == 0) {
            return false;
        }
        if (visited.contains(index)){
            return true;
        } else {
            visited.add(index);
        }
        for (UndirectedGraphNode node : graph[index].neighbors) {
            if (hasCycle(graph, node.label, visited)) {
                return true;
            }
            visited = new HashSet<>();
        }
        return false;
    }


    public static void main(String[] args) {
        int numCourse = 4;
        int[][] prerequisites = {{1, 0},
                {0, 2},
                {2, 1},
                {2, 3}
        };
        System.out.println(canFinish(numCourse, prerequisites));
    }
}
