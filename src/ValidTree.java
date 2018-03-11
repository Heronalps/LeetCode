import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            for (int child : graph.get(node)) {
                if (child != node) {
                    queue.offer(child);
                    graph.get(child).remove((Integer) node);
                    // 这是BFS中最关键的一步，为了不走回头路，需要把child到parent的edge去掉。
                    // 注意，必须使用Integer进行cast，否则node会被作为index对待。
                }
            }
        }
        for (boolean bool : visited) {
            if (!bool) return false;
        }
        return true;
    }
}
