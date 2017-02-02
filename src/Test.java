import java.util.*;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
// 3 steps
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

// BFS the whole graph and add all nodes to the arraylist
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        nodes.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!nodes.contains(neighbor)) {
                    nodes.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

// Copy nodes to old->new hash map
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

// Copy nodes’ neighbors
        for (UndirectedGraphNode n : map.keySet()) {
            UndirectedGraphNode newNode = map.get(n);
            ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<>();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                newNeighbors.add(map.get(neighbor));
            }
            newNode.neighbors = newNeighbors;
        }
        return map.get(node);
    }

    public static void main(String[] args){
        /*UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        zero.neighbors.add(one);
        zero.neighbors.add(two);
        one.neighbors.add(two);
        two.neighbors.add(two);


        UndirectedGraphNode newHead = cloneGraph(zero);
        System.out.println(newHead.neighbors);
        */
        UndirectedGraphNode minusOne = new UndirectedGraphNode(-1);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        minusOne.neighbors.add(one);

        System.out.println(cloneGraph(minusOne).neighbors);

    }
}


