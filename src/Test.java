import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {

    private static class Node{
        private int id;
        private Node(int id){
            this.id = id;
        }
        public String toString(){
            return "node";
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        Node n = new Node(5);
        System.out.println(n.toString());
        Graph g = new Graph();
        g.addNode("nodeName");
        //Graph.Node node = g.new Node("name");
    }

}
