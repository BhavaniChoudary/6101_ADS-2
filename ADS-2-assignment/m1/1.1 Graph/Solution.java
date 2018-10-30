import java.util.Scanner;
interface Graph {
    int v1();
    int e1();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    boolean hasEdge(int v, int w);
}
final class Solution {
    private Solution() {

    }
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
