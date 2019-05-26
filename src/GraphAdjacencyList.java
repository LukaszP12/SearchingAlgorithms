import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GraphAdjacencyList {
    private Map<Integer, ArrayList<Integer>> adjListMap;

    public GraphAdjacencyList(int vertices) {
        adjListMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= vertices; i++) {
            ArrayList<Integer> neighbours = new ArrayList<Integer>();
            adjListMap.put(i, neighbours);
        }
    }

    public void addEdge(int v, int w) {
        if (v > adjListMap.size() || w > adjListMap.size()) {
            return;
        }
        (adjListMap.get(v)).add(w);
        (adjListMap.get(w)).add(v);
    }
    public ArrayList<Integer> getNeighbours(int v){
        if(v > adjListMap.size()){
            return null;
        }
        return new ArrayList<Integer>(adjListMap.get(v));
    }
    public static void main(String args[]){
        int count = 1,source, dest;
        System.out.println("Enter the number of vertices and edges");
        Scanner scan = new Scanner(System.in);
        int number_vertices = scan.nextInt();
        int number_edges = scan.nextInt();
        GraphAdjacencyList adjacencyList = new GraphAdjacencyList(number_vertices);
        System.out.println("Enter edges in format <source> <destination>");
        while (count <= number_edges){
            source = scan.nextInt();
            dest = scan.nextInt();
            adjacencyList.addEdge(source,dest);
            count++;
        }
        System.out.println("The given adjacency list for the graph\n");
        for(int i=1;i<number_vertices;i++){
            System.out.println(i + "->");
            ArrayList<Integer> edgeList = adjacencyList.getNeighbours(i);
            for(int j=1;; j++){
                if(j!=edgeList.size()){
                    System.out.println(edgeList.get(j-1)+" -> ");
                }
                else{
                    System.out.println(edgeList.get(j-1));
                    break;
                }
            }
            System.out.println();
        }
    }
}
