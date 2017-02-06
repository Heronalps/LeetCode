import java.util.*;

/**
 * Created by michaelzhang on 2/5/17.
 */
public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        // Sanity Check
        if (n != edges.length + 1) {
            return false;
        }
        Map<Integer, ArrayList<Integer>> neighbors = new HashMap<>();

//Initiate map
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new ArrayList<Integer>());
        }
        for (int row = 0; row < edges.length; row++) {
            neighbors.get(edges[row][0]).add(edges[row][1]);
            neighbors.get(edges[row][1]).add(edges[row][0]);
        }

//BFS
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            visited[current] = true;
            for (int neighbor : neighbors.get(current)) {
                if (visited[neighbor] == true) {
                    continue;
                }
                queue.offer(neighbor);
            }
        }
        return count == n;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(validTree(5,edges ));
    }
}
