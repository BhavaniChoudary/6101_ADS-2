public class GraphList implements Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int v1;
    private int e1;
    private Bag<Integer>[] adj;
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
    public int v1() {
        return v1;
    }
    public int e1() {
        return e1;
    }
    private void validateVertex(final int v) {
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException("vertex " + v
                                               + " is not between 0 and "
                                               + (v1 - 1));
        }
    }

    public void addEdge(final int v, final int w) {
        e1++;
        adj[v].add(w);
        adj[w].add(v);
    }

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

    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

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
