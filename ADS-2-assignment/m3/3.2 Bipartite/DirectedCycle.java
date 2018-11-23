/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * marked.
     */
    private boolean[] marked;
    /**
     *  edgeTo.
     */
    private int[] edgeTo;
    /**
     * onStack.
     */
    private boolean[] onStack;
    /**
     * directed cycle.
     */
    private Stack<Integer> cycle;
    /**
     * boolean.
     */
    private boolean isbipartite = false;
    /**
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    public DirectedCycle(final Graph g) {
        marked  = new boolean[g.vertex()];
        onStack = new boolean[g.vertex()];
        edgeTo  = new int[g.vertex()];
        for (int v = 0; v < g.vertex(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(g, v);
            }
        }
    }
    /**
     * dfs.
     * complexity is O(e).
     * e refers to no.of edges
     *
     * @param      g     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Graph g, final int v) {
        isbipartite = !isbipartite;
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }
    /**
     * Determines if it has cycle.
     * complexity is O(1).
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * Iterator.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**
     * check.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {
        if (hasCycle()) {
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
            if (first != last) {
                System.out.println(
                    "cycle begins with %d and ends with %d\n" + first + last);
                return false;
            }
        }
        return true;
    }
    /**
     * bipartite.
     * complexity is O(1).
     *
     * @return     { description_of_the_return_value }
     */
    public boolean isbipartite() {
        return isbipartite;
    }
}


