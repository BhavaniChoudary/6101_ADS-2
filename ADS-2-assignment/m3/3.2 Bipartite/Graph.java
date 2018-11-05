/**
 * Class for graph.
 */
public class Graph {
    /**
     * vertices var_description.
     */
    private int vertices;
    /**
     * edges var_description.
     */
    private int edges;
    /**
     * adj var_description.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      v     { parameter_description }
     */
    public Graph(final int v) {
        if (v < 0) {
            throw new RuntimeException(
                "Number of vertices must be nonnegative");
        }
        this.vertices = v;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * vertex.
     *
     * @return     { description_of_the_return_value }
     */
    public int vertex() {
        return vertices;
    }
    /**
     * edge.
     *
     * @return     { description_of_the_return_value }
     */
    public int edge() {
        return edges;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * iterator.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
}


