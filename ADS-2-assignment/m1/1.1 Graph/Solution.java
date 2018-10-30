import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * v1 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    int v1();
    /**
     * e1 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    int e1();
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**
     * adjacent function_description.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    Iterable<Integer> adj(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**
 * class Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * main function_description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        String[] nodes = new String[2];
        int v, e1;
        if (type.equals("List")) {

            v = Integer.parseInt(sc.nextLine());
            e1 = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(",");

            GraphList g = new GraphList(v);
            for (int i = 0; i < e1; i++) {
                String[] add = sc.nextLine().split(" ");
                int a = Integer.parseInt(add[0]);
                int b = Integer.parseInt(add[1]);
                if (a != b && !g.hasEdge(a, b)) {
                    g.addEdge(a, b);
                }
            }
            System.out.println(g.display(input));
        } else if (type.equals("Matrix")) {
            v = 0;
            e1 = 0;
            v = Integer.parseInt(sc.nextLine());
            e1 = Integer.parseInt(sc.nextLine());

            String[] line = sc.nextLine().split(",");
            int[][] graph = new int[v][v];
            int a, b;
            while      (sc.hasNext()) {
                nodes = sc.nextLine().split(" ");
                a = Integer.parseInt(nodes[0]);
                b = Integer.parseInt(nodes[1]);
                if (a != b) {
                    graph[a][b] = 1;

                    if (graph[b][a] == 1) {
                        e1--;
                    } else {
                        graph[b][a] = 1;
                    }
                }
            }
            if (v == 1) {
                System.out.println(v + " vertices, " + (e1 - 1) + " edges");

            } else {
                System.out.println(v + " vertices, " + e1 + " edges");

            }
            if (v <= 1) {
                System.out.println("No edges");
            } else {
                for (int[] each : graph) {
                    for (int each2 : each) {
                        System.out.print(each2 + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}


