import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * The main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int roadLines = sc.nextInt();
        sc.nextLine();
        EdgeWeightedGraph gr = new EdgeWeightedGraph(cities);
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(cities);
        for (int i = 0; i < roadLines; i++) {
            String[] tokens = sc.nextLine().split(" ");
            gr.addEdge(new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2])));
            g.addEdge(new DirectedEdge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2])));
            g.addEdge(new DirectedEdge(Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[2])));
        }
        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            System.out.println(gr);
            break;
        case "DirectedPaths":
            // Handle the case of DirectedPaths,
            // where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] tokens1 = sc.nextLine().split(" ");
            DijkstraSP sp = new DijkstraSP(g,
                Integer.parseInt(tokens1[0]));
            if (sp.hasPathTo(Integer.parseInt(tokens1[1]))) {
                int temp = Integer.parseInt(tokens1[1]);
                double dis = sp.distTo(temp);
                System.out.println(dis);
            } else {
                System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is the via is the one where path
            // should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            break;
        default:
            break;
        }

    }
}
