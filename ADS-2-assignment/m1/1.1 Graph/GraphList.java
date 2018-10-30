/**
 * List of graphs.
 */
public class GraphList implements Graph {
    /**
     * NEWLINE var_description.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * v1 var_description.
     */
    private final int v1;
    /**
     * e1 var_description.
     */
    private int e1;
    /**
     * Bag var_description.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      v11   The v 11
     */
    public GraphList(final int v11) {
        if (v11 < 0) {
            throw new IllegalArgumentException("Number"
                                               + " of vertices must"
                                               + " be nonnegative");
        }
        this.v1 = v11;
        this.e1 = 0;
        adj = (Bag<Integer>[]) new Bag[v11];
        for (int v = 0; v < v11; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * v1 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int v1() {
        return v1;
    }
    /**
     * e1 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int e1() {
        return e1;
    }
    /**
     * validateVertex function_description.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException("vertex " + v
                                               + " is not between 0 and "
                                               + (v1 - 1));
        }
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        e1++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        int count = 0;
        for (int i : adj[v]) {
            if (i == w) {
                count += 1;
                break;
            }
        }
        for (int i : adj[w]) {
            if (i == v) {
                count += 1;
                break;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
    /**
     * adjacent function_description.
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
     * returns degree.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
    /**
     * display.
     *
     * @param      data  The data
     *
     * @return     { description_of_the_return_value }
     */
    public String display(final String[] data) {
        StringBuilder s = new StringBuilder();
        s.append(v1 + " vertices, " + e1 + " edges" + NEWLINE);
        if (e1 > 0) {
            for (int v = 0; v < v1; v++) {
                s.append(data[v] + ": ");
                for (int w : adj[v]) {
                    s.append(data[w] + " ");
                }
                s.append(NEWLINE);
            }
        } else {
            s.append("No edges");
        }
        return s.toString();
    }
}
