/**
 * Class for connected components
 */
public class CC {
    /**
     * marked var_description.
     */
    private boolean[] marked;
    /**
     * id var_description.
     */
    private int[] id;
    /**
     * size var_description.
     */
    private int[] size;
    /**
     * count var_description.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      graph  The graph
     */
    public CC(final Graph graph) {
        marked = new boolean[graph.vertices()];
        id = new int[graph.vertices()];
        size = new int[graph.vertices()];
        for (int v = 0; v < graph.vertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }
    /**
     * dfs function_description.
     *
     * @param      graph  The graph
     * @param      v      { parameter_description }
     */
    private void dfs(final Graph graph, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }
    public int count() {
        return count;
    }
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    @Deprecated
    public boolean areConnected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    private void validateVertex(final int v) {
        int vertices = marked.length;
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (vertices - 1));
        }
    }
}