/**
 * Class for connected components.
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
     * Computes the connected components.
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
     * dfs of graph.
     * complexity is O(N).
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
    /**
     * Returns the component id of the connected
     * component containing vertex.
     * complexity in average case is 1.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }
    /**
     * size function_description.
     * complexity in average case is 1.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }
    /**
     * count function_description.
     * complexity in average case is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int count() {
        return count;
    }
    /**
     * returns true if vertices are in the same connected components.
     * complexity in average case is 1.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    /**
     * returns true is vertices are in the same connected components.
     * complexity is O(1).
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    @Deprecated
    public boolean areConnected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    /**
     * validating.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int vertices = marked.length;
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (vertices - 1));
        }
    }
}

