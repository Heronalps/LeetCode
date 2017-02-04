import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by michaelzhang on 2/2/17.
 */
public class TopSort {
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
//Sanity check
        if (graph == null || graph.size() == 0) {
            return result;
        }
// Create a map of nodes and the number of edges points to it
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(node)) {
                    map.put(node, 0);
                }
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

// Add all nodes that don’t have an point-to edge to the queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : map.keySet()) {
            if (map.get(node) == 0) {
                queue.offer(node);
            }
        }

// Traverse the graph
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            if (!result.contains(node)) {
                result.add(node);
            }
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor)-1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        DirectedGraphNode zero = new DirectedGraphNode(0);
        DirectedGraphNode one = new DirectedGraphNode(1);
        DirectedGraphNode two = new DirectedGraphNode(2);
        DirectedGraphNode three = new DirectedGraphNode(3);
        DirectedGraphNode four = new DirectedGraphNode(4);
        //DirectedGraphNode five = new DirectedGraphNode(5);

        zero.neighbors.add(one);
        zero.neighbors.add(two);
        zero.neighbors.add(three);
        zero.neighbors.add(four);
        one.neighbors.add(three);
        one.neighbors.add(four);
        two.neighbors.add(one);
        two.neighbors.add(four);
        three.neighbors.add(four);

        ArrayList<DirectedGraphNode> list = new ArrayList<>();
        list.add(zero);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        System.out.println(topSort(list));
    }
}
