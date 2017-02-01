import javax.swing.tree.*;
import java.util.*;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] postCourse = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            postCourse[i] = new ArrayList<Integer>();
        }
        for(int row = 0; row < numCourses; row++) {
            postCourse[prerequisites[row][1]].add(prerequisites[row][0]);
            degree[prerequisites[row][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        int courseCount = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            courseCount++;
            for (int i = 0; i < postCourse[course].size(); i++) {
                int post = (int) postCourse[course].get(i);
                degree[post]--;
                if (degree[post] == 0) {
                    queue.add(post);
                }
            }
        }
        return courseCount == numCourses;
    }

}


