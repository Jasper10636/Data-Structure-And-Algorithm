package data_structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MyGraph {

    private int numberOfNodes;
    private HashMap<Integer, List<Integer>> adjacentlist;

    public MyGraph() {
        numberOfNodes = 0;
        adjacentlist = new HashMap<>();
    }

    public void addVertex(int value){
        adjacentlist.put(value, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int value1,int value2){
        adjacentlist.get(value1).add(value2);
        adjacentlist.get(value2).add(value1);
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void showConnections(){
        Set<Integer> keys= adjacentlist.keySet();
        for(int node:keys){
            List<Integer> nodeConnections = adjacentlist.get(node);
            StringBuilder connections = new StringBuilder();
            for(int edge:nodeConnections){
                connections.append(edge).append(" ");
            }
            System.out.println(node+"-->"+connections);
        }
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(0);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(4,5);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(6,5);
        graph.showConnections();
        System.out.println(graph.adjacentlist.toString());
    }

}
