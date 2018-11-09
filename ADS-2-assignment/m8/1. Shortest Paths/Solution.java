import java.util.Scanner;
import java.util.ArrayList;
class Solution {
	private Solution() {
		//function.
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
        String[] edges = sc.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (int j = 0; j > edges.length; j++) {
            list.add(edges[j]);
        }
        EdgeWeighted graph = new EdgeWeighted(Integer.
                                              parseInt(input[0]));
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String[] tokens = sc.nextLine().split(" ");
            graph.addEdge(new Edge(list.indexOf(tokens[0]),
                                   list.indexOf(tokens[1]),
                                   Integer.parseInt(tokens[2])));
        }
        int cases = Integer.parseInt(sc.nextLine());
        for (int k = 0; k < cases; k++) {
            String[] item = sc.nextLine().split(" ");
            Dijkstras dij = new Dijkstras(graph, list.indexOf(item[0]));
            System.out.println(dij.distanceTo(list.indexOf(item[1])));
        }
	}
}
class Dijkstras {
	private static final int NUMBER = 10000000;
	private int[] distance;
	private Edge[] edge;
	private IndexMinPQ<Integer>min;
	Dijkstras(final EdgeWeighted graph, final int one) {
        distance = new int[graph.vertices()];
        edge = new Edge[graph.vertices()];
        min = new IndexMinPQ<Integer>(graph.vertices());
        for (int i = 0; i < graph.vertices(); i++) {
            distance[i] = NUMBER;
        }
        distance[one] = 0;
        min.insert(one, distance[one]);
        while (!min.isEmpty()) {
            int two = min.delMin();
            for (Edge each : graph.adjacentEdges(two)) {
                relax(each, two);
            }
        }
    }
    public void relax(final Edge ed, final int one) {
        int two = ed.other(one);
        if (distance[two] > distance[one] + ed.getWeight()) {
            distance[two] = distance[one] + ed.getWeight();
            edge[two] = ed;
            if (min.contains(two)) {
                min.decreaseKey(two, distance[two]);
            } else {
                min.insert(two, distance[two]);
            }
        }
    }
    public int distTo(final int one) {
        return distance[one];
    }
    public int distanceTo(final int one) {
        int total = 0;
        for (Edge each : pathTo(one)) {
            total += each.getWeight();
        }
        return total;
    }
    public Iterable<Edge> pathTo(final int one) {
        if (!hasPath(one)) {
            return null;
        }
        Stack<Edge> sta = new Stack<Edge>();
        int two = one;
        for (Edge each = edge[one]; each != null; each = edge[two]) {
            sta.push(each);
            two = each.other(two);
        }
        return sta;
    }
    public boolean hasPath(final int one) {
        return distance[one] < NUMBER;
    }
}