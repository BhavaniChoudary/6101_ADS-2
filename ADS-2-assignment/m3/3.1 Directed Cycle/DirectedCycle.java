/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * marked var_description.
     */
    private boolean[] marked;
    /**
     * edgeTo var_description.
     */
    private int[] edgeTo;
    /**
     * onStack var_description.
     */
    private boolean[] onStack;
    /**
     * directed cycle var_description.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    public DirectedCycle(final Digraph g) {
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
     * dfs function_description.
     *
     * @param      g     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Digraph g, final int v) {
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
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * Iterator.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**
     * check function_description.
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
}

