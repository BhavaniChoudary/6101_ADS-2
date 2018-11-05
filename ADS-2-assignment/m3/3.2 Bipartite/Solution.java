import java.util.Scanner;
public final class Solution {
    private Solution() {
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numofvertices = Integer.parseInt(s.nextLine());
        int numofedges = Integer.parseInt(s.nextLine());
        Graph graph = new Graph(numofvertices);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[0]));
        }
        DirectedCycle dircycle = new DirectedCycle(graph);
        if (dircycle.isbipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}