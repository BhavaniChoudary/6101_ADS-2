/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * class digraph.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * vertices var_description.
     */
    private final int ver;
    /**
     * edge var_description.
     */
    private int edg;
    /**
     * adjacency list for vertex.
     */
    private Bag<Integer>[] adj;
    /**
     * indegree of vertex.
     */
    private int[] indegree;
    /**
     * Constructs the object.
     *
     * @param      ver1  The version 1
     */
    public Digraph(final int ver1) {
        if (ver1 < 0) {
            throw new IllegalArgumentException(
                "Number of vertices in a Digraph must be nonnegative");
        }
        this.ver = ver1;
        this.edg = 0;
        indegree = new int[ver];
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    public Digraph(final Digraph g) {
        this(g.vertex());
        this.edg = g.edge();
        for (int v = 0; v < ver; v++) {
            this.indegree[v] = g.indegree(v);
        }
        for (int v = 0; v < g.vertex(); v++) {
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : g.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
    /**
     * vertex count.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public int vertex() {
        return ver;
    }
    /**
     * edge count.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public int edge() {
        return edg;
    }
    /**
     * validate vertex.
     * complexity is O(1).
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= ver) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (ver - 1));
        }
    }
    /**
     * Adds an edge.
     * complexity is O(1).
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        edg++;
    }
    /**
     * Iterator.
     * complexity is O(1).
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }
    /**
     * outdegree.
     * complexity is O(1).
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
    /**
     * indegree.
     * complexity is O(1).
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }
    /**
     * reverse the digraph.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(ver);
        for (int v = 0; v < ver; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
    /**
     * Returns a string representation of the object.
     * complexity is O(N^2).
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(ver + " vertices, " + edg + " edges " + NEWLINE);
        for (int v = 0; v < ver; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}

